package com.example.secondapp.content_provider

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.secondapp.R
import java.util.jar.Manifest

class MainActivityContact : AppCompatActivity() {

    private lateinit var contactListView: RecyclerView
    private lateinit var contacts:ArrayList<Contact>
    private lateinit var adapter:RecyclerAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager


    @RequiresApi(Build.VERSION_CODES.O)
    fun init()

    {   contacts=ArrayList();
        var resolver=contentResolver
        contactListView=findViewById(R.id.recyclerviewid)
        var cursor=resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);


        while (cursor!!.moveToNext()){
            var mob=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
            var name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            var contact=Contact(name,mob);
            contacts.add(contact);
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_contact)

        permission();
        init()
        adapter= RecyclerAdapter(this,contacts)
        layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        contactListView.layoutManager=layoutManager
        contactListView.adapter=adapter
    }


     fun permission(){
         if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.READ_CONTACTS)!=PackageManager.PERMISSION_GRANTED){
             ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_CONTACTS),200);
         }
     }




}

