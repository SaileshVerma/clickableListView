package com.example.secondapp.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.core.view.get
import com.example.secondapp.MyAdapter
import com.example.secondapp.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class StudentListDataActivity : AppCompatActivity(),ValueEventListener {

   private lateinit var adapter:MineAdapter
  private lateinit var  studentdata:ArrayList<Students>
private lateinit var listview:ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list_data)
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Student")
        myRef.addValueEventListener(this)
        studentdata= ArrayList();
    listview=findViewById(R.id.firebaselistview)

    listview.setOnItemClickListener{
            parent,view, position, id ->
        var selectedItemdata=studentdata.get(position);
        Toast.makeText(this,selectedItemdata.name,Toast.LENGTH_LONG).show();
        var bundle=Bundle()
      bundle.putString("name",selectedItemdata.name)
        bundle.putString("id",selectedItemdata.id);
        var intent=Intent(this,UpdateDataActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent);



    }
    }



    override fun onDataChange(snapshot: DataSnapshot) {

studentdata.clear();
        for(data in snapshot.children){

           val stu=data.getValue(Students::class.java)!!

           studentdata.add(stu);
            adapter= MineAdapter(this,studentdata);
           listview.adapter=adapter
       }
    }

    override fun onCancelled(error: DatabaseError) {

    }


}