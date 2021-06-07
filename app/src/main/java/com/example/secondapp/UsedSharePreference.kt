package com.example.secondapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class UsedSharePreference : AppCompatActivity() {


    private lateinit var preference: SharedPreferences
    private lateinit var showTextname: TextView;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_used_share_preference)
        init()
        //preference=getPreferences(Context.MODE_PRIVATE);
        preference=getSharedPreferences("myapp",Context.MODE_PRIVATE);
        var name=preference.getString("username","");
        showTextname.setText(name);

    }

    fun init() {
        showTextname = findViewById(R.id.showname);
    }
}