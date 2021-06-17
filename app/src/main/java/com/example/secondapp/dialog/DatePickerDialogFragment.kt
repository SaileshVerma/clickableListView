package com.example.secondapp.dialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerDialogFragment:DialogFragment(),DatePickerDialog.OnDateSetListener {
    private  lateinit var  comm:Communication;
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
         super.onCreateDialog(savedInstanceState)
var cal=Calendar.getInstance()

        var year=cal.get((Calendar.YEAR))
        var month=cal.get((Calendar.MONTH))
        var date=cal.get((Calendar.DATE))
        var dialog=DatePickerDialog(requireContext(),this,year,month,date);
        return dialog;

    }
    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
       var date=p1.toString()+":"+p2.toString()+" : "+p3.toString();
        comm.getname(date);
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        comm=context as Communication
    }

}