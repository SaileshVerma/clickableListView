package com.example.secondapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.secondapp.navigation.MailFragment

class JIETDatabase(context: Context) :SQLiteOpenHelper(context,"jietdb",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {


        var create_table:String="CREATE TABLE STUDENT(ID INTEGER  PRIMARY KEY AUTOINCREMENT"+
        ",NAME TEXT,ROLLNUMBER TEXT,SEMESTER TEXT,DEPARTMENT TEXT)"


        p0?.execSQL(create_table)


    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun addNewStudent(student:Student):Boolean{
      var db=writableDatabase;
        var contentValues=ContentValues();
       // contentValues.put("ID",student.id);
        contentValues.put("NAME",student.name);
        contentValues.put("ROLLNUMBER",student.rollno);
        contentValues.put("SEMESTER",student.semester);
        contentValues.put("DEPARTMENT",student.dept);

      return  db.insert("STUDENT",null,contentValues)>0;


    }
//    fun checkname(name:String):Boolean{
//        var db=readableDatabase;
//        var query="SELECT NAME FROM STUDENT WHERE NAME = name";
//
//        var cursor=db.rawQuery(query,null);
//        var names=cursor.getString(cursor.getColumnIndex("NAME"))
//
//
//
//    }




  fun getAllStudents():ArrayList<Student>{

      var db=readableDatabase
      var data=ArrayList<Student>()
      var query="SELECT * FROM STUDENT";
     var cursor= db.rawQuery(query,null);


      while(cursor.moveToNext()){
          var id=cursor.getInt(cursor.getColumnIndex("ID")).toString()
          var name=cursor.getString(cursor.getColumnIndex("NAME"))
          var rollno=cursor.getString(cursor.getColumnIndex("ROLLNUMBER"))
          var sem=cursor.getString(cursor.getColumnIndex("SEMESTER"))
          var dept=cursor.getString(cursor.getColumnIndex("DEPARTMENT"))
          var student=Student(id,name,rollno,sem,dept);
          data.add(student);

      }

          return data;
  }

    fun removeStudent(id:String):Boolean
    {
        //"DELETE STUDENT WHERE ID=ID_VALUE AND NAME=NAME_VALUE"
        var db=writableDatabase
        return db.delete("STUDENT","ID=?", arrayOf(id))>0
    }


    fun updateStudent(id:String,student:Student):Boolean{


        var db=writableDatabase;
        var contentValues=ContentValues();
        // contentValues.put("ID",student.id);
        contentValues.put("NAME",student.name);
        contentValues.put("ROLLNUMBER",student.rollno);
        contentValues.put("SEMESTER",student.semester);
        contentValues.put("DEPARTMENT",student.dept);
return db.update("STUDENT",contentValues,"ID=?", arrayOf(id))>0
    }



}