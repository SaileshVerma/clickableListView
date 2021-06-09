package com.example.secondapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast

class StudentActivity : AppCompatActivity() {

private lateinit var  studentlistviewlayout:ListView
private lateinit var studentdata:ArrayList<Student>
private lateinit var  adpater:StudentAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        init()
        initdata()
        if(studentdata.size==0){
            Toast.makeText(this, "NO RECORDS FOUND", Toast.LENGTH_LONG).show();
        }
        adpater= StudentAdapter(this,studentdata)
        studentlistviewlayout.adapter=adpater;
    }


fun init(){
    studentlistviewlayout=findViewById(R.id.studentListView);


}

    fun initdata(){
        var database=JIETDatabase(this)
        studentdata=database.getAllStudents();
    }





    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        menuInflater.inflate(R.menu.menubar,menu)
        return true;


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.add->{
                var intent=Intent(this,AddStudentActivity::class.java)
                startActivity(intent);

                true}
            R.id.delete->{true}
            R.id.exit->{
                finish()
                true}



            else-> super.onOptionsItemSelected(item)
        }



    }
}