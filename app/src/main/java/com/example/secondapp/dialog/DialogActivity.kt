package com.example.secondapp.dialog




import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.secondapp.R


class DialogActivity : AppCompatActivity() , Communication {
    private lateinit var confirmbtn:Button
    private lateinit var infobtn:Button
    private lateinit var singlechoicebtn:Button
    private lateinit var multichoicebtn:Button
    private lateinit var cutombtn:Button
    private lateinit var datepickerbtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        init()
        listeners()

    }
    fun init(){
        confirmbtn=findViewById(R.id.confirmbtn)
        infobtn=findViewById(R.id.infodialogbtn)
        singlechoicebtn=findViewById(R.id.singlechoicebtn)
        multichoicebtn=findViewById(R.id.multichoicebtn)
        cutombtn=findViewById(R.id.custombtn)
        datepickerbtn=findViewById(R.id.datepickerbtn);

    }
    fun listeners(){
        confirmbtn.setOnClickListener(){
            var confirmDialog=ConfirmDialogFragment()
           confirmDialog.show(supportFragmentManager,"ConfirmDialog")
   cutombtn.setOnClickListener(){
       var customDialog=CustomDialogFragment()
       customDialog.show(supportFragmentManager,"CustomDialog")
   }
            datepickerbtn.setOnClickListener(){
                var datePicker=DatePickerDialogFragment();
                datePicker.show(supportFragmentManager,"datePicker");
            }
            singlechoicebtn.setOnClickListener(){
                var singleDialog=SingleChoiceDialogFragment()
                singleDialog.show(supportFragmentManager,"singleDialog")
            }

        }




    }

    override fun onBackPressed() {
        var confirmDialog=ConfirmDialogFragment()
        confirmDialog.show(supportFragmentManager,"ConfirmDialog")
    }

    override fun getname(name: String) {
      Toast.makeText(this,name,Toast.LENGTH_LONG).show()
    }

}