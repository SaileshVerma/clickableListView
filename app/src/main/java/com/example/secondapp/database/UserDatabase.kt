package com.example.secondapp.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

import com.example.secondapp.navigation.User

class UserDatabase(context: Context) : SQLiteOpenHelper(context,"newdb",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
//        var create_table:String="CREATE TABLE STUDENT(ID INTEGER  PRIMARY KEY AUTOINCREMENT"+
//                ",NAME TEXT,ROLLNUMBER TEXT,SEMESTER TEXT,DEPARTMENT TEXT)"


        var create_table: String = "CREATE TABLE USERDETAIL(USERNAME TEXT  PRIMARY KEY" +
                ",EMAIL TEXT,PASSWORD TEXT,MOBILE TEXT,GENDER TEXT)";


        p0?.execSQL(create_table)


    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun addNewUser(user: User): Boolean {
        var db = writableDatabase;
        var contentValues = ContentValues();

        contentValues.put("USERNAME", user.username);
        contentValues.put("EMAIL", user.email);
        contentValues.put("PASSWORD", user.password);
        contentValues.put("MOBILE", user.mobile);
        contentValues.put("GENDER",user.gender);

        return db.insert("USERDETAIL", null, contentValues) > 0;


    }
    fun loginUser(mail:String,password:String):Boolean{
        var db=readableDatabase;
//        var query=;
        var cursor=db.rawQuery("SELECT * FROM USERDETAIL WHERE EMAIL=?", arrayOf(mail));




return cursor.count>0;
    }

    fun checkUsername(name: String): Boolean {
        var db = readableDatabase;


        var cursor = db.rawQuery("SELECT * FROM USERDETAIL WHERE USERNAME=?", arrayOf(name));

      return cursor.count>0;
    }
}













