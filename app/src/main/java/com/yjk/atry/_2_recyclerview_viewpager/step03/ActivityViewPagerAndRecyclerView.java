package com.yjk.atry._2_recyclerview_viewpager.step03;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

import com.yjk.atry.R;
import com.yjk.atry._2_recyclerview_viewpager.step03.adapter.ViewPagerAdapterStep3;
import com.yjk.atry._2_recyclerview_viewpager.step03.datamodel.PictureDataModel;
import com.yjk.atry._2_recyclerview_viewpager.step03.dialog.DialogAddPicture;
import com.yjk.common.callback.SingleClickListener;
import com.yjk.common.util.TCameraGalleryUtil;
import com.yjk.common.util.TLog;
import com.yjk.common.view.base.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 도전과제 3
 */
public class ActivityViewPagerAndRecyclerView extends BaseActivity {

    private RelativeLayout relativeLayoutTitleBar;
    private RelativeLayout relativeLayoutAdd;
    private ViewPager2 viewPagerMain;
    private ViewPagerAdapterStep3 adapter;
    private RelativeLayout relativeLayoutOne;
    private RelativeLayout relativeLayoutTwo;
    private TextView textViewNoPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage2_step3_main);

        initView();
        setEvent();

        initViewPager();
    }


    @Override
    protected void initView() {

        relativeLayoutTitleBar = (RelativeLayout) findViewById(R.id.relativeLayoutTitleBar);
        relativeLayoutAdd = (RelativeLayout) findViewById(R.id.relativeLayoutAdd);
        viewPagerMain = (ViewPager2) findViewById(R.id.viewPagerMain);
        relativeLayoutOne = (RelativeLayout) findViewById(R.id.relativeLayoutOne);
        relativeLayoutTwo = (RelativeLayout) findViewById(R.id.relativeLayoutTwo);
        textViewNoPicture = (TextView) findViewById(R.id.textViewNoPicture);
    }

    @Override
    protected void setEvent() {

        relativeLayoutOne.setOnClickListener(v -> viewPagerMain.setCurrentItem(0));
        relativeLayoutTwo.setOnClickListener(v -> viewPagerMain.setCurrentItem(1));

        relativeLayoutAdd.setOnClickListener(new SingleClickListener(() -> {
            new DialogAddPicture(mContext, new DialogAddPicture.IPictureAddCallback() {
                @Override
                public void onCamera() {
                    new TCameraGalleryUtil().startCamera(ActivityViewPagerAndRecyclerView.this);
                }

                @Override
                public void onAlbum() {
                    new TCameraGalleryUtil().startGallery(ActivityViewPagerAndRecyclerView.this);
                }
            }).show();
        }));

    }

    private void initViewPager() {
        adapter = new ViewPagerAdapterStep3(this);
        viewPagerMain.setAdapter(adapter);
        viewPagerMain.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPagerMain.setOffscreenPageLimit(1);

        viewPagerMain.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                relativeLayoutOne.setSelected(position == 0);
                relativeLayoutTwo.setSelected(position == 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        new TCameraGalleryUtil().onActivityResult(requestCode, resultCode, data, new TCameraGalleryUtil.IImageCallback() {
            @Override
            public void getUri(@NonNull Uri uri) {

                try {
                    // Uri -> Bitmap
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), uri);

                    // uri 정보 가져오기
//                    String[] projections = {MediaStore.Images.Media._ID, MediaStore.Images.Media.DISPLAY_NAME, MediaStore.Images.Media.DATE_TAKEN};
//                    Cursor cursor = mContext.getContentResolver().query(uri, projections, null, null, null);

//                    int idIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID);
//                    int displayNameIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME);
//                    int dateIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_TAKEN);

//                    long id = cursor.getLong(idIndex);
//                    String name = cursor.getString(displayNameIndex);
//                    Date date = new Date(cursor.getLong(dateIndex));
                    String time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

                    addData(bitmap, time);


                } catch (Exception e) {
                    TLog.e(e);
                }
            }

            @Override
            public void getBitmap(@NonNull Bitmap bitmap) {
                try {
                    String time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
                    addData(bitmap, time);
                } catch (Exception e) {
                    TLog.e(e);
                }
            }

            @Override
            public void onError(@NonNull String msg) {
                Toast.makeText(mContext, "msg", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addData(Bitmap bitmap, String time) {
        PictureDataModel data = new PictureDataModel(bitmap, time);
        adapter.addData(data);
        textViewNoPicture.setVisibility(View.GONE);
    }
}
