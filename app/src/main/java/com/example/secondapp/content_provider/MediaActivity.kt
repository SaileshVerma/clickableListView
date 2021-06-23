package com.example.secondapp.content_provider

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.VideoView
import androidx.core.app.ActivityCompat
import com.example.secondapp.R

class MediaActivity : VideoCommun,AppCompatActivity() {
    lateinit var  videoView: VideoView
    lateinit var dialogFrag:ChooseMediaFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)
        init()
        requestPermissions()
        var dialogfrag=ChooseMediaFragment()
        dialogfrag.show(supportFragmentManager,"mediaFragment");
//        var builder = AlertDialog.Builder(this)
//        builder.setTitle("Get Media From")
//        var data=arrayOf("Gallery", "Camera")
//        builder.setItems(data) { dialog, which ->
//            if (which == 0) {
//                gallery()
//            } else if(which==1) {
//                selectVideoFromCamera()
//            }else{
////                dismiss()
//            }
//        }
//        var dialog = builder.create()
//        dialog.setCanceledOnTouchOutside(false)
//        dialog.show()

       }


    fun init(){
        videoView = findViewById<VideoView>(R.id.videoView)
    }
    override fun gallery(){
        //var intent = Intent(Intent.ACTION_VIEW, MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
        var intent=Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("video/*");
        startActivityForResult(intent, 300)
    }
    override fun selectVideoFromCamera(){
        var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, 100)
    }

    fun requestPermissions(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==300 && resultCode== Activity.RESULT_OK && data!=null){
          //  println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.")
            var uri=data.data
            videoView.setVideoURI(uri)
            videoView.requestFocus()
            videoView.start()
        }

        if(requestCode==100 && resultCode== Activity.RESULT_OK && data!=null){
            //println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>.")
            var uri=data.data
            videoView.setVideoURI(uri)
            videoView.requestFocus()
            videoView.start()
        }
    }
}