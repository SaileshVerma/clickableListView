package com.example.secondapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu

class StudentActivity : AppCompatActivity(),AdapterView.OnItemLongClickListener {

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
        adpater.notifyDataSetChanged();
        studentlistviewlayout.setOnItemLongClickListener(this);
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
    override fun onItemLongClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long): Boolean {
        var popup_menu=PopupMenu(this,p1!!)
        var menuInflator=popup_menu.menuInflater;
           menuInflator.inflate(R.menu.popmenu,popup_menu.menu)
        popup_menu.show()
           popup_menu.setOnMenuItemClickListener(
           PopupMenu.OnMenuItemClickListener {

            when(it?.itemId){


                R.id.deleteRec->{

                    var stud=studentdata.get(p2)
                    var db=JIETDatabase(applicationContext)
                    if(db.removeStudent(stud.id)){
                        adpater.removeStudentData(stud);
                        Toast.makeText(applicationContext,"Data remover",Toast.LENGTH_SHORT).show();
                    }


                    true
                }
              R.id.updateRec->{
                  var stud=studentdata.get(p2)
                var intent=Intent(this,UpdateActivity::class.java)
                  intent.putExtra("ID",stud.id)
                  intent.putExtra("NAME",stud.name)
                  intent.putExtra("SEMESTER",stud.semester)
                  intent.putExtra("ROLLNO",stud.rollno)
                  intent.putExtra("DEPT",stud.dept)
                   startActivity(intent)



                  true
              }

                else -> {true}
            }
        }



    )

    return true}


}


