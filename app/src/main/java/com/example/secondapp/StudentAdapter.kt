package com.example.secondapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class StudentAdapter(private var ctx: Context, private var studentdata:ArrayList<Student>):BaseAdapter() {
    override fun getCount(): Int {
      return studentdata.size
    }

    override fun getItem(p0: Int): Any {
       return studentdata.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {


        var inflator=ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE )  as LayoutInflater
        var view= inflator.inflate(R.layout.student_row_layout,p2,false);
        var nametextview=view.findViewById<TextView>(R.id.nametextview)
        var rollno=view.findViewById<TextView>(R.id.rollnotextview)
        var roundcharview=view.findViewById<TextView>(R.id.roundchartext)
        var deptview=view.findViewById<TextView>(R.id.depttextview)
        var sem=view.findViewById<TextView>(R.id.semview)

        var data=getItem(p0) as Student


        nametextview.setText(data.name)
        rollno.setText(data.rollno)
        roundcharview.setText(data.name.get(0).toString())
        deptview.setText(data.dept)
        sem.setText(data.semester);

        return view;



    }


    fun removeStudentData(student: Student){
        studentdata.remove(student)
        notifyDataSetChanged();
    }
}