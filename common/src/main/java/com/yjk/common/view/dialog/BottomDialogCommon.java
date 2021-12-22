package com.yjk.common.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.yjk.common.R;

/**
 * Bottom Dialog 기본형
 */
public class BottomDialogCommon extends BottomSheetDialogFragment {
    private Context mContext;
    private static BottomDialogCommon mDialog;
    private IBottomDialogCallback mCallback;

    private BottomDialogCommon(){}

    public static BottomDialogCommon getInstance(IBottomDialogCallback callback) {
        mDialog = new BottomDialogCommon();
        Bundle arg = new Bundle();
        arg.putParcelable("callback", callback);
        mDialog.setArguments(arg);
        return mDialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.bottom_dialog_common, null);
        initView(view);
        setEvent();
//        setWindow(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getDialog().setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                BottomSheetDialog d = (BottomSheetDialog) dialog;
                View bottomSheetInternal = d.findViewById(R.id.design_bottom_sheet);
                BottomSheetBehavior.from(bottomSheetInternal).setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

    }

    @Override
    public void onCancel(@NonNull DialogInterface dialog) {
        super.onCancel(dialog);
    }

    private void initView(View view) {
        mContext = getContext();

        Bundle arg = getArguments();
        if(arg != null){
            mCallback = arg.getParcelable("callback");
        }

    }

    private void setEvent() {

    }

//    private void setWindow(View view) {
//        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme);
//    }


//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        return new BottomSheetDialog(getContext(), R.style.CustomBottomSheetDialogTheme);
//    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    public interface IBottomDialogCallback extends Parcelable {
        void onConfirm();
        void onCancel();

        @Override
        default int describeContents() {
            return 0;
        }

        @Override
        default void writeToParcel(Parcel parcel, int i) {

        }
    }
}