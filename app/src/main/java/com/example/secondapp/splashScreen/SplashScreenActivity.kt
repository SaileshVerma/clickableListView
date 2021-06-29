package com.example.secondapp.splashScreen

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.ProgressBar
import com.example.secondapp.R
import java.lang.Exception

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var logoImgView:ImageView
    private lateinit var progressBar: ProgressBar
    //private  var handler: Handler= Handler();
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        setContentView(R.layout.activity_splash_screen)
        init();
        progressBar.progressDrawable.setColorFilter(Color.rgb(0,230,0),android.graphics.PorterDuff.Mode.SRC_IN);
        var rotate=RotateAnimation(0F,360F,Animation.RELATIVE_TO_SELF,0.5F,Animation.RELATIVE_TO_SELF,0.5F )
        rotate.duration=1400
        logoImgView.startAnimation(rotate);

        Thread(object :Runnable{
            var i=0
            var progressStatus=0;
            override fun run(){
                while(progressStatus<100){
                    progressStatus=progressStatus+i*4
                    try {
                        Thread.sleep(340)
                    }catch(e:Exception){}
                    progressBar.progress=progressStatus;i++;
                }

            }

        }).start()


        Handler().postDelayed({
            var intent=Intent(this,TempMainActivity::class.java)
            startActivity(intent)
            finish()
        },2800);




    }
    fun init(){
        logoImgView=findViewById(R.id.logoimgview)
        progressBar=findViewById(R.id.progressView)
    }
}