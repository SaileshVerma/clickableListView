package com.example.secondapp.navigation

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.service.autofill.UserData
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.secondapp.R
import com.example.secondapp.database.UserDatabase

class SignUpFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_sign_up, container, false)


        var newUserMail=view.findViewById<EditText>(R.id.newuseridview);
        var newPassword=view.findViewById<EditText>(R.id.newpasswordview);
        var newUserName=view.findViewById<EditText>(R.id.newusernamevview);
        var mobile=view.findViewById<EditText>(R.id.mobileview);
        var signUpbtn=view.findViewById<Button>(R.id.signupbtn);


        newUserName.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

            @SuppressLint("ResourceAsColor")
            @RequiresApi(Build.VERSION_CODES.M)

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            if(p0!!.length>5){
            var database=UserDatabase(requireContext());
            if(database.checkUsername(p0.toString())){

           newUserName.setError("UserName Exist");
           }else{
           newUserName.setError(null);
                }
            }
            }

            override fun afterTextChanged(p0: Editable?) { }

        })



        signUpbtn.setOnClickListener(){
            var database=UserDatabase(requireContext());
            var name=newUserName.text.toString();
            var mobilenumber=mobile.text.toString()
            var password=newPassword.text.toString();
            var email=newUserMail.text.toString();
            var radiogrp=view.findViewById<RadioGroup>(R.id.radiogroup);
            var radiobtn=view.findViewById(radiogrp.checkedRadioButtonId) as RadioButton;
            var gender=radiobtn.text.toString();

         if( database.addNewUser(User(name,email,password,mobilenumber,gender))){
             Toast.makeText(requireContext(),"New User Register",Toast.LENGTH_SHORT).show();
             val transaction = activity?.supportFragmentManager?.beginTransaction()
             transaction?.replace(R.id.fragment_container
                 , CallFragment());
             transaction?.commit()
         }

        }


   return view; }


}