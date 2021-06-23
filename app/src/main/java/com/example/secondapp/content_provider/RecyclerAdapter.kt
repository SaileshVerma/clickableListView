package com.example.secondapp.content_provider

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.secondapp.R

public class RecyclerAdapter(var context:Context,var contactdata:ArrayList<Contact>):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var numberTextView=itemView.findViewById<TextView>(R.id.contactnumber)
        var nameTextView=itemView.findViewById<TextView>(R.id.contactname)
    }



    @SuppressLint("ServiceCast")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflator=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view=layoutInflator.inflate(R.layout.contactrowview,parent,false)
        println("Recycler-View Created")
        return ViewHolder(view)
    }



    override fun getItemCount(): Int {
return contactdata.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var contact=contactdata.get(position) as Contact
        holder.nameTextView.setText(contact.name)
        holder.numberTextView.setText(contact.mobno)
    }
}