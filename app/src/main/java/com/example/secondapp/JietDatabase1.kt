package com.example.jietapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class JietDatabase(context: Context):SQLiteOpenHelper(context,"jiet_db",null,1)
{
    override fun onCreate(db: SQLiteDatabase?)
    {
        var create_table:String="CREATE TABLE STUDENT(ID TEXT PRIMARY KEY" +
                ",NAME TEXT,ROLLNUMBER TEXT,SEMESTER TEXT,DEPARTMENT TEXT)"
        db?.execSQL(create_table)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {

    }

    fun addNewStudent(student: Student):Boolean
    {
        var db=writableDatabase
        var contentValues=ContentValues()
        contentValues.put("ID",student.id)
        contentValues.put("NAME",student.name)
        contentValues.put("ROLLNUMBER",student.rollnumber)
        contentValues.put("SEMESTER",student.semester)
        contentValues.put("DEPARTMET",student.department)
        return db.insert("STUDENT",null,contentValues)>0
    }

    fun getAllStudent():ArrayList<Student>
    {
        var students=ArrayList<Student>()
        var db=readableDatabase
        var query="SELECT * FROM STUDENT"
        var cusror=db.rawQuery(query,null)
        while(cusror.moveToNext())
        {
            var id=cusror.getString(cusror.getColumnIndex("ID"))
            var name=cusror.getString(cusror.getColumnIndex("NAME"))
            var rollnumber=cusror.getString(cusror.getColumnIndex("ROLLNUBER"))
            var semester=cusror.getString(cusror.getColumnIndex("SEMESTER"))
            var department=cusror.getString(cusror.getColumnIndex("DEPARTMENT"))
            var student=Student(id,name,rollnumber,semester,department)
            students.add(student)
        }
        return students
    }

    fun removeStudent(id:String):Boolean
    {
        "DELETE STUDENT WHERE ID=ID_VALUE AND NAME=NAME_VALUE"
        var db=writableDatabase
        return db.delete("STUDENT","ID=?", arrayOf(id))>0
    }


}