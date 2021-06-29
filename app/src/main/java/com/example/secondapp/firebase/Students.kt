package com.example.secondapp.firebase

import android.media.Image

class Students {

   public lateinit var name:String
     public lateinit   var rolnum:String
     public lateinit  var id:String


    public constructor(id:String,name:String,rolnum:String){
        this.id=id
        this.name=name;
        this.rolnum=rolnum
    }
    public  constructor();

}