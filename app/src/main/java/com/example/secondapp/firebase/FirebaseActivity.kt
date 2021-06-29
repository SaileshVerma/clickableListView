package com.example.secondapp.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.secondapp.R
import com.google.firebase.database.DatabaseReference

import com.google.firebase.database.FirebaseDatabase




class FirebaseActivity : AppCompatActivity() {
    private lateinit var name:TextView
    private lateinit var rollnm:TextView
    private lateinit var save:Button
    private lateinit var movetonext:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase)
init()

       save.setOnClickListener() {
           var namedata=name.text.toString()
           var roldata=rollnm.text.toString();

           val database = FirebaseDatabase.getInstance()
           val myRef = database.getReference("Student")
          var id=myRef.push().key as String
           var student=Students(id,namedata,roldata);
           myRef.child(id).setValue(student);

       }
        movetonext.setOnClickListener(){
            var intent=Intent(this,StudentListDataActivity::class.java)
            startActivity(intent);
        }



    }

    fun init(){
        name=findViewById(R.id.stunametext)
        rollnm=findViewById(R.id.rollnumtextview)
        save=findViewById(R.id.saveubtn)
        movetonext=findViewById(R.id.movetonextbtn);
    }
}