package com.example.secondapp.content_provider

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.secondapp.R
import com.example.secondapp.dialog.Communication

class ChooseMediaFragment : DialogFragment() {
lateinit var listener:VideoCommun;


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        super.onCreateDialog(savedInstanceState)
        var builder= AlertDialog.Builder(requireContext())
        builder.setTitle("SELECT from given :")
       // builder.setMessage("Do you wana to select ")
         var   data= arrayOf("Gallery","Video")


         builder.setItems(data){

         dialog,which->
         if(which==0){
             listener.gallery();
         }else if(which==1){
             listener.selectVideoFromCamera();
         }else{
         dismiss()

     }


     };
        var dialog=builder.create();

        dialog.setCanceledOnTouchOutside(false)
         return dialog;
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as VideoCommun
    }


}