package com.example.secondapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class UpdateActivity : AppCompatActivity() {
    private lateinit var enternameview: EditText
    private  lateinit var enterrollno: EditText
    private lateinit var semspinner: Spinner
    private lateinit var  deptspinner: Spinner
    private lateinit var semadapter: ArrayAdapter<String>
    private lateinit var deptadapter: ArrayAdapter<String>
    private  lateinit var database:JIETDatabase
    private lateinit var savebtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        init()
        spinnerdatainit()
   fillstudentdetail()



        savebtn.setOnClickListener() {
            var name = enternameview.text.toString()
            var rollno = enterrollno.text.toString()
            var deptmnt = deptspinner.selectedItem as String
            var semi = semspinner.selectedItem as String
            var id = intent.getStringExtra("ID")
            database = JIETDatabase(this)
            var stud = Student(name, rollno, semi, deptmnt)
            if (database.updateStudent(id.toString(), stud)) {
                Toast.makeText(applicationContext, "Record Updatedddd Successfully", Toast.LENGTH_LONG).show()
                var intent= Intent(this,StudentActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"DO again",Toast.LENGTH_SHORT).show()
            }


        }


    }
    fun fillstudentdetail(){
        var id=intent.getStringExtra("ID")
        var name=intent.getStringExtra("NAME")
        var sem=intent.getStringExtra("SEMESTER")
        var roll=intent.getStringExtra("ROLLNO")
        var dept=intent.getStringExtra("DEPT")
     enternameview.setText(name)
        enterrollno.setText(roll)
        semspinner.setSelection(semadapter.getPosition(sem))
        deptspinner.setSelection(deptadapter.getPosition(dept));



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