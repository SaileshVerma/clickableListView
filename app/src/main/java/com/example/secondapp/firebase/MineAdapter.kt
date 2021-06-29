package com.example.secondapp.firebase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.secondapp.Name
import com.example.secondapp.R

class MineAdapter (private var ctx: Context,private var data:ArrayList<Students>) : BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(p0: Int): Any {
        return data.get(p0);
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var inflator = ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vview = inflator.inflate(R.layout.rowlayoutlist, p2, false);

        var text = vview.findViewById<TextView>(R.id.nameText)
        var round = vview.findViewById<TextView>(R.id.round);

        var d = getItem(p0) as Students



        text.setText(d.name)
        round.setText(d.name.get(0).toString())

        return vview;
    }
}