package com.example.secondapp.navigation

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.secondapp.R
import com.example.secondapp.database.UserDatabase

class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_login, container, false)
        var usermail=view.findViewById<EditText>(R.id.usermailview);
        var password=view.findViewById<EditText>(R.id.passwordview);
        var signInbtn=view.findViewById<Button>(R.id.signinbtn);
        var database=UserDatabase(requireContext());
        var preference=activity?.getSharedPreferences("loginstatus",Context.MODE_PRIVATE);
        var editor= preference?.edit() as SharedPreferences.Editor;




        signInbtn.setOnClickListener(){
            if(database.loginUser(usermail.text.toString(),password.text.toString())){
                editor.putString("status","yes");
                editor.commit();
                Toast.makeText(requireContext(),"login successfully",Toast.LENGTH_SHORT).show();
                val transaction = activity?.supportFragmentManager?.beginTransaction()
                transaction?.replace(R.id.fragment_container
                    , CallFragment());
                transaction?.commit()

            }else{
                usermail.setError("INVALID USERNAME OR PASSWORD");
                password.setError("INVALID PASSWORD OR USERNAME");
            }
        }

        return view

    }


}