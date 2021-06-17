package com.example.secondapp.dialog


import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.secondapp.R

class SingleChoiceDialogFragment :DialogFragment(){
    private  lateinit var comm:Communication

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)

        var builder= AlertDialog.Builder(requireContext())
        builder.setTitle("EXIT")
        builder.setMessage("Do you wana to exit")
   builder.setItems(R.array.dept,DialogInterface.OnClickListener { dialogInterface, i ->

        var data=activity?.resources?.getStringArray(R.array.dept)
       var selectedData=data?.get(i)
       comm.getname(selectedData.toString())
       dismiss()

   })

        return builder.create()
    }
    override fun onAttach(context: Context) {  //this is called first before oncreate and here we can get obj of activity
        super.onAttach(context)
        comm=context as Communication
    }
}