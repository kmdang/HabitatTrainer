package com.example.kdang.habittrainer

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_create_habit.*
import java.io.IOException

class CreateHabitActivity : AppCompatActivity() {

    private val TAG = CreateHabitActivity::class.java.simpleName

    private val CHOOSE_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_habit)
    }

    fun chooseImage(v: View) {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        val chooser = Intent.createChooser(intent, "Choose image for habit")
        startActivityForResult(chooser, CHOOSE_IMAGE_REQUEST)

        Log.d(TAG, "Intent to choose image sent...")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // make sure the intent returned as the correct requestCode,
        // that the result code is ok and that there is data
        if (requestCode == CHOOSE_IMAGE_REQUEST && resultCode == Activity.RESULT_OK
                && data != null && data.data != null) {
            Log.d(TAG, "An image was chosen by the user")

            val bitmap = tryReadBitmap(data.data)

            // set the image to te xml property
            bitmap?.let {
                iv_image.setImageBitmap(bitmap)
                Log.d(TAG, "Read image bitmap and updated the image view")
            }
        }

    }

    // return a bitmap representation of the photo chosen
    private fun tryReadBitmap(data: Uri): Bitmap? {
        return try {
            MediaStore.Images.Media.getBitmap(contentResolver, data)
        } catch(e: IOException) {
            e.printStackTrace()
            null
        }

    }
}
