package com.example.secondapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bndle=intent.extras;
        var data=bndle?.getString("name")
        var text=findViewById<TextView>(R.id.t1);
        text.setText(data);


    }
}