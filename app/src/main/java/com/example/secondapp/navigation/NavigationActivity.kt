package com.example.secondapp.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast

import androidx.appcompat.app.ActionBarDrawerToggle

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment

import com.example.secondapp.R
import com.google.android.material.navigation.NavigationView

class NavigationActivity : AppCompatActivity() {
    private lateinit var toolbar:Toolbar
    private lateinit var drawer:DrawerLayout
    private lateinit var navigationView:NavigationView
    private lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        init()
       setSupportActionBar(toolbar)
       // supportFragmentManager.beginTransaction().replace().commit();
       var toogle=ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
       drawer.addDrawerListener(toogle)
       toogle.syncState()
       navigationView.setNavigationItemSelectedListener{
           var fragment:Fragment?=null;
           when(it.itemId){
               R.id.location->{
                   fragment=BluetoothFragment();
                   Toast.makeText(this,"location",Toast.LENGTH_SHORT).show()
                   true

               }else->{true}



           }
           var manager=supportFragmentManager
           manager.beginTransaction().replace(R.id.fragment_container,fragment as Fragment).commit();

           it.setChecked(true)
           drawer.closeDrawers()
           true


       }

    }
    fun init(){
        toolbar=findViewById(R.id.toolbar)
        drawer=findViewById(R.id.drawerLayout)
        navigationView=findViewById(R.id.navigationView)
        frameLayout=findViewById(R.id.fragment_container)



    }


}