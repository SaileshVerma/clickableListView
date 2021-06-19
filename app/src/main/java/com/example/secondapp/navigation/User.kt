package com.example.secondapp.navigation

class User {


    public lateinit var username:String;
    public lateinit var email:String;
    public lateinit var password:String;
    public lateinit var mobile:String;
    public lateinit var gender:String;

    public constructor(username:String,email:String,password:String,mobile:String,gender:String){
        this.username=username;
        this.email=email;
        this.password=password;
        this.mobile=mobile;
        this.gender=gender
    }

}