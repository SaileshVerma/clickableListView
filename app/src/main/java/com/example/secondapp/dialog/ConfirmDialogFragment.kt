package com.example.secondapp.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ConfirmDialogFragment: DialogFragment() {
    private  lateinit var dialogActivity: DialogActivity
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
         super.onCreateDialog(savedInstanceState)

        var builder=AlertDialog.Builder(requireContext())
        builder.setTitle("EXIT")
        builder.setMessage("Do you wana to exit")
        builder.setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->
dialogActivity.finish()
        })
        builder.setNegativeButton("No",DialogInterface.OnClickListener{
            dialogInterface,i-> dismiss()
        })

        return builder.create()
    }

    override fun onAttach(context: Context) {  //this is called first before oncreate and here we can get obj of activity
        super.onAttach(context)
        dialogActivity=context as DialogActivity
    }
}