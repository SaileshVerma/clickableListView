package com.example.secondapp

class Student {
    public lateinit var id:String;
    public lateinit var name:String;
    public lateinit var rollno:String;
    public lateinit var semester:String;
    public lateinit var dept:String;

public constructor(id:String,name:String,rollno:String,semester:String,dept:String)

{this.id=id;
    this.name=name;
    this.rollno=rollno;
    this.semester=semester;
    this.dept=dept;


}

   public constructor(name:String,rollno:String,semester:String,dept:String){
       this.name=name;
       this.rollno=rollno;
       this.semester=semester;
       this.dept=dept;
   }



}