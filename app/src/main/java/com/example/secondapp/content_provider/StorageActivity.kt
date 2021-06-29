package com.example.secondapp.content_provider

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import com.example.secondapp.R
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.*

class StorageActivity : AppCompatActivity() {
    private lateinit var imageView:ImageView
    private lateinit var internalsavebtn:Button
    private lateinit var cachesavebtn:Button
    private lateinit var publicsavebtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)
        init();
        permissions();
        internalsavebtn.setOnClickListener(){
              var intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,101)


                               }

           cachesavebtn.setOnClickListener(){
            var intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,201)

        }

        publicsavebtn.setOnClickListener(){
            var intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,301)

        }



    }



    fun permissions(){  if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 100)
    }

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 100)
        }
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 100)
        }


    }

     fun init(){
        imageView=findViewById(R.id.imageView)
        internalsavebtn=findViewById(R.id.internalsavebtn)
       cachesavebtn=findViewById(R.id.cachesavebtn)
       publicsavebtn=findViewById(R.id.publicsavebtn);
      }

//
//     fun getrealpathofimg(uri:Uri):String{ print("...........>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><")
//        var projection= arrayOf(MediaStore.Images.Media.DATA);
//        var cursor=contentResolver.query(uri,projection,null,null,null);
//
//         if(cursor!=null&&cursor!!.moveToFirst())
//
//            return cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
//           else return null.toString();
//                                          }





     fun savefile(status:Int,filepath:String){
      var currfile=File(filepath);
      var wallpaperdirectory:File?= null

      if(status==0){
               wallpaperdirectory=File(cacheDir,"wallpaper")


      }
      if (status==1){
          wallpaperdirectory= getExternalFilesDir("wallpaper")!!

      }
      if(status==2){
          wallpaperdirectory=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
      }


          if (wallpaperdirectory != null) {
              if(!wallpaperdirectory.exists())
              wallpaperdirectory.mkdir()
          }


      var outputfile=File(wallpaperdirectory,"img"+Calendar.getInstance().timeInMillis.toString()+".jpg")
          if(currfile.exists()){
          var inputFileStream=FileInputStream(currfile);
          var outputfileStream=FileOutputStream(outputfile);

          var i=inputFileStream.read();
          while(i!=-1){
              outputfileStream.write(i)
              i=inputFileStream.read()
          }
          inputFileStream.close()
          outputfileStream.close()

      }


  }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
  if(requestCode==201&&resultCode==Activity.RESULT_OK&&data!=null){
      //for internal

     //  savefile(0);

      var bitmap=data.extras?.get("data") as Bitmap
      imageView.setImageBitmap(bitmap)
     var wallpaperdirectory=File(cacheDir,"wallpaper")
    if(!wallpaperdirectory.exists()){
        wallpaperdirectory.mkdir();
    }
      var outputfile=File(wallpaperdirectory,"img.jpg")
      var outstream=FileOutputStream(outputfile)
      bitmap.compress(Bitmap.CompressFormat.JPEG,100,outstream);
      outstream.flush()
    outstream.close();
  }

        if(requestCode==101&&resultCode==Activity.RESULT_OK&&data!=null){
         //for cache
//            var uri=data?.data
//            var path=getrealpathofimg(uri!!);
//            savefile(1,path);

            var bitmap=data.extras?.get("data") as Bitmap
            imageView.setImageBitmap(bitmap)
           // var wallpaperdirectory=File(cacheDir,"wallpaper")
           var wallpaperdirectory= getExternalFilesDir("wallpaper")!!
            if(!wallpaperdirectory.exists()){
                wallpaperdirectory.mkdir();
            }
            var outputfile=File(wallpaperdirectory,"img.jpg")
            var outstream=FileOutputStream(outputfile)
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,outstream);
            outstream.flush()
            outstream.close();
        }


        if(requestCode==301&&resultCode==Activity.RESULT_OK&&data!=null){
       // for public
//            var uri=data?.data
//            var path=getrealpathofimg(uri!!);
//            savefile(2,path);

            var bitmap=data.extras?.get("data") as Bitmap

            var  wallpaperdirectory=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            if(!wallpaperdirectory.exists()){
                wallpaperdirectory.mkdir();
            }
            var outputfile=File(wallpaperdirectory,"img11111.jpg")
            var outstream=FileOutputStream(outputfile)
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,outstream);
            outstream.flush()
            outstream.close(); imageView.setImageBitmap(bitmap)
        }



    }
}