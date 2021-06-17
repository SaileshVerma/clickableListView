package com.example.secondapp.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.secondapp.R

class CustomDialogFragment:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)

        var builder= AlertDialog.Builder(requireContext())
        builder.setTitle("EXIT")
        var view=activity?.layoutInflater?.inflate(R.layout.progresslayout,null,false);
        builder.setView(view)



        return builder.create()
    }
}