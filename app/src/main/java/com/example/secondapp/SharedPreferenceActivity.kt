package com.example.secondapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SharedPreferenceActivity : AppCompatActivity() {
    private lateinit var preference:SharedPreferences
    private lateinit var  unameedit:EditText;
    private lateinit var  savebtn:Button;
private lateinit var nextbtn:Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)
        init()


//        preference=getPreferences(Context.MODE_PRIVATE);
//        var name=preference.getString("username","");
//        unameedit.setText(name);
//





        savebtn.setOnClickListener(){
            var username=unameedit.text.toString();
           // preference=getPreferences(Context.MODE_PRIVATE)
            preference=getSharedPreferences("myapp",Context.MODE_PRIVATE);
            var editor=preference.edit() as SharedPreferences.Editor
            editor.putString("username",username)
            editor.commit();

        }

        nextbtn.setOnClickListener(){
            var intent=Intent(this,UsedSharePreference::class.java)
      startActivity(intent)
        }


    }


    fun init(){
  nextbtn=findViewById(R.id.nextbtn)
     unameedit=findViewById(R.id.username);
        savebtn=findViewById(R.id.savebtn);

    }
}