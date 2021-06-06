package com.example.secondapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class CountriesAdapter(var context: Context,var countries:ArrayList<String>,var statemap:HashMap<String,ArrayList<String> >):BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return countries.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return statemap.size
    }

    override fun getGroup(p0: Int): Any {
        return countries.get(p0)
    }

    override fun getChild(p0: Int, p1: Int): Any {
        return statemap.get(countries.get(p0))?.get(p1) as String
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
       return p0.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        var layoutInflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var convertView=layoutInflater.inflate(R.layout.parent_row_layout,p3,false)
        var parentTextView=convertView.findViewById(R.id.parentView) as TextView
        var countryName=getGroup(p0) as String
        parentTextView.setText(countryName)
        return convertView
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        var layoutInflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var convertView=layoutInflater.inflate(R.layout.child_row_layout,p4,false)
        var childTextView=convertView.findViewById(R.id.childView) as TextView
        var stateName=getChild(p0,p1) as String
        childTextView.setText(stateName);
        
        return convertView


    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
       return true
    }


}