package com.example.saveimage

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.lang.Exception
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val button = findViewById<Button>(R.id.button)
            val image_view_saved = findViewById<ImageView>(R.id.image_view_saved)
            val image_view_source = findViewById<ImageView>(R.id.image_view_source)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // Check run time permission for write external storage
                // android.permission.WRITE_EXTERNAL_STORAGE
            }

            // Click listener for button widget
            button.setOnClickListener {
                // Disable the save button
                it.isEnabled = false

                // Save the image to gallery and get saved image Uri
                val uri = saveImage(image_view_source.drawable, "Winter")
                ToastMessage("saved : $uri")

                // Show the saved image in an image view
                image_view_saved.setImageURI(uri)
            }
        }


        // Method to save an image to gallery and return uri
        private fun saveImage(drawable: Drawable, title: String): Uri {
            // Get the image from drawable resource as drawable object

            // Get the bitmap from drawable object
            val bitmap = (drawable as BitmapDrawable).bitmap

            // Save image to gallery
            val savedImageURL = MediaStore.Images.Media.insertImage(
                contentResolver,
                bitmap,
                title,
                "Image of $title"
            )

            // Parse the gallery image url to uri
            return Uri.parse(savedImageURL)
        }
    }

    // Extension function to show toast message
    private fun Context.ToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


