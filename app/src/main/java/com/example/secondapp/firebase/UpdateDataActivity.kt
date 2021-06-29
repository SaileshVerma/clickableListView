package com.example.secondapp.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.secondapp.R
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class UpdateDataActivity : AppCompatActivity() {
    private lateinit var updateBtn:Button
    private lateinit var deleleBtn:Button
    private lateinit var textView: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_data)
        init()
        var bundle=intent.extras
        var name=bundle?.getString("name")
        var id=bundle?.getString("id");
        textView.setText(name)
        updateBtn.setOnClickListener(){


            var newName=textView.text.toString()
            var firebase=FirebaseDatabase.getInstance()
            val ref=firebase.getReference("Student")
            ref.child(id.toString()).child("name").setValue(newName);
            Toast.makeText(this,"Item UPDATED",Toast.LENGTH_SHORT).show()
            finish();

        }
        deleleBtn.setOnClickListener(){
            var firebase=FirebaseDatabase.getInstance()
            val ref=firebase.getReference("Student")
            ref.child(id.toString()).removeValue();
            Toast.makeText(this,"Item DEleted",Toast.LENGTH_SHORT).show()
            finish();
        }



    }
    fun init(){
        updateBtn=findViewById(R.id.savedatabtn)
        deleleBtn=findViewById(R.id.deletebtn);
        textView=findViewById(R.id.updatenameview);
    }
}