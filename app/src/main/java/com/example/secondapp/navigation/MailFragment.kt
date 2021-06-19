package com.example.secondapp.navigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.example.secondapp.JIETDatabase
import com.example.secondapp.R


class MailFragment : Fragment() {


    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view=inflater.inflate(R.layout.fragment_mail, container, false)
    var nameText=view.findViewById<EditText>(R.id.editTextTextPersonName);
    var db=JIETDatabase(requireContext());
//   nameText.addTextChangedListener{
//       if(db.checkname(it.toString())){
//           println(it.toString());
//           nameText.setBackgroundColor(R.color.purple_500)
//       }else{
//           println("not exist fasle"+it.toString());
//           nameText.setBackgroundColor(R.color.white);
//
//       }
//
//   }


        return view;
    }


}