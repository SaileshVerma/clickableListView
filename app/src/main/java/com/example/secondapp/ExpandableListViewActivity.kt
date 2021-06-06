package com.example.secondapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListView

class ExpandableListViewActivity : AppCompatActivity() {
    private lateinit var expandableListView:ExpandableListView
    private lateinit var countries:ArrayList<String>
    private lateinit var stateList:HashMap<String,ArrayList<String> >
private lateinit var adapter:CountriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_list_view)
         init()
    initdata()
        adapter=CountriesAdapter(this,countries,stateList)
        expandableListView.setAdapter(adapter);


    }

   fun init(){
       expandableListView=findViewById(R.id.expandableListView);



   }
fun initdata(){


    countries=ArrayList()
    countries.add("India")
    countries.add("pakistan")


    var indiastateList=ArrayList<String>()
    indiastateList.add("Rajasthan")
    indiastateList.add("Tamil Nadu")
    indiastateList.add("Venkeswar")

    var pakstatelist=ArrayList<String>()
    pakstatelist.add("saye1")
    pakstatelist.add("state2")

    stateList= HashMap()
    stateList.put("India",indiastateList)
    stateList.put("pakistan",pakstatelist);





}


}