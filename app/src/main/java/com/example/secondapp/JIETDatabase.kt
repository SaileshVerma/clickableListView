package com.example.secondapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class JIETDatabase(context:Context) :SQLiteOpenHelper(context,"jietdb",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {


        var create_table:String="CREATE TABLE STUDENT(ID TEXT PRIMARY KEY"+
        ",NAME TEXT,ROLLNUMBER TEXT,SEMESTER TEXT,DEPARTMENT TEXT)"


        p0?.execSQL(create_table)


    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun addNewStudent(student:Student):Boolean{

    }
    


}