package com.example.secondapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class AddStudentActivity : AppCompatActivity() {
private lateinit var enternameview:EditText
private  lateinit var enterrollno:EditText
private lateinit var semspinner:Spinner
private lateinit var  deptspinner:Spinner
private lateinit var semadapter:ArrayAdapter<String>
private lateinit var deptadapter:ArrayAdapter<String>
private  lateinit var database:JIETDatabase
private lateinit var savebtn:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        init()
        spinnerdatainit()
        savebtn.setOnClickListener(){
          var name=enternameview.text.toString()
            var rollno=enterrollno.text.toString()
            var deptmnt=deptspinner.selectedItem as String
            var semi=semspinner.selectedItem as String
            if(name.isEmpty()){
                enternameview.setError("naam enter kr be saale")
                return@setOnClickListener
            }
            if(rollno.isEmpty()){
                enterrollno.setError("roll no kon dalega padosi tera")
return@setOnClickListener
            }

            //database= JIETDatabase(applicationContext)
            var stud=Student(name,rollno,semi,deptmnt)
            if(database.addNewStudent(stud)){
                Toast.makeText(applicationContext, "Record Added Successfully", Toast.LENGTH_LONG).show()
                var intent= Intent(this,StudentActivity::class.java)
                startActivity(intent)
            }else{

                Toast.makeText(applicationContext,"DO again",Toast.LENGTH_SHORT).show()
            }




        }
    }

    fun  init(){
        enternameview=findViewById(R.id.enternameview)
        enterrollno=findViewById(R.id.enterrollnoview)
        savebtn=findViewById(R.id.saverecbtn)
        semspinner=findViewById(R.id.semspinner)

        deptspinner=findViewById(R.id.deptspinner)


    }

  fun spinnerdatainit(){

      var semdata=resources.getStringArray(R.array.semester)
      var deptdata=resources.getStringArray(R.array.dept);
      semadapter= ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,semdata)
      deptadapter= ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,deptdata)
     semspinner.adapter=semadapter
      deptspinner.adapter=deptadapter

  }

}