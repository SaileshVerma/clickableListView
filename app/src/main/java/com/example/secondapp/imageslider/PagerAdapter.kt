package com.example.secondapp.imageslider

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PagerAdapter( manager:FragmentManager):FragmentStatePagerAdapter(manager) {


    override fun getItem(position: Int): Fragment {
     var fragment:Fragment?=null
     when(position){
         0->fragment=FirstImgFragment()
         1->fragment=SecondImgFragment()
     }



     return fragment!!;
           }

    override fun getCount(): Int {
return 2;
    }
}