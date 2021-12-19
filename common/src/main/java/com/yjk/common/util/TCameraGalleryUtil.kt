package com.yjk.common.util

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import com.yjk.common.util.TImageUtil

/**
 * Camera & Gallery 로부터 이미지를 가져오는 유틸
 */
class TCameraGalleryUtil {

    companion object {
        val REQUEST_CODE_CAMERA = 9998
        val REQUEST_CODE_GALLERY = 9997
    }

    fun startCamera(activity: Activity) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        activity.startActivityForResult(intent, REQUEST_CODE_CAMERA)
    }

    fun startGallery(activity: Activity) {
        val intent = Intent();
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        activity.startActivityForResult(intent, REQUEST_CODE_GALLERY)
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent, callback : IImageCallback) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CODE_CAMERA) {
                if (data.extras != null && data.hasExtra("data")) {
                    val bitmap = data.extras!!["data"] as Bitmap?
                    if(bitmap != null){
                        callback.getBitmap(bitmap)
                        return
                    }
                }
                callback.onError("이미지를 불러올 수 없습니다.")
            } else if (requestCode == REQUEST_CODE_GALLERY) {
                try {
                    val uri: Uri? = data.data
                    if(uri != null){
                        callback.getUri(uri)
                        return
                    }
                    callback.onError("이미지를 불러올 수 없습니다.")
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }


    interface IImageCallback {
        fun getUri(uri: Uri)
        fun getBitmap(bitmap: Bitmap)
        fun onError(msg : String)
    }
}