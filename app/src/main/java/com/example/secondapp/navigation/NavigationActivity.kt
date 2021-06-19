package com.example.secondapp.navigation

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast

import androidx.appcompat.app.ActionBarDrawerToggle

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.secondapp.JIETDatabase

import com.example.secondapp.R
import com.example.secondapp.Student
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
        var preference=getSharedPreferences("loginstatus", Context.MODE_PRIVATE);
        var status=preference.getString("status","");
        if(status=="yes"){
            hidemenu();
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,CallFragment()).commit();
        }else{

            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,LoginFragment()).commit();
        }


       var toogle=ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
       drawer.addDrawerListener(toogle)
       toogle.syncState()

     //   navigationView.getMenu().getItem(0).setVisible(false);
       navigationView.setNavigationItemSelectedListener{
           var fragment:Fragment?=null;
           when(it.itemId){

               R.id.mail->{
                   fragment=MailFragment();
                   Toast.makeText(this,"mail",Toast.LENGTH_SHORT).show()
                  // navigationView.getMenu().getItem(0).setVisible(false);
                   true
               }

               R.id.call->{
                   fragment=CallFragment();
                   Toast.makeText(this,"call",Toast.LENGTH_SHORT).show()
                  // navigationView.getMenu().getItem(2).setVisible(false);
                   true
               }
               R.id.setting->{
                   fragment=SettingFragment();
                   Toast.makeText(this,"setting",Toast.LENGTH_SHORT).show()
                 //  navigationView.getMenu().getItem(1).setVisible(false);
                   true
               }
               R.id.login->{
                   var manager=supportFragmentManager
              manager.beginTransaction().replace(R.id.fragment_container, LoginFragment()).commit();
               }
               R.id.newsignUP->{
                   var manager=supportFragmentManager
                   manager.beginTransaction().replace(R.id.fragment_container, SignUpFragment()).commit();
               }
              R.id.signout->{
                  var preference=getSharedPreferences("loginstatus", Context.MODE_PRIVATE);
                  var editor=preference.edit() as SharedPreferences.Editor;
                  editor.putString("status","no");
                  editor.commit();
                //  visiblemenu();
                  val transaction = supportFragmentManager.beginTransaction()
                  transaction.replace(R.id.fragment_container, LoginFragment());
                  transaction.commit()

              }
               R.id.location->{
                   fragment=BluetoothFragment();
                   Toast.makeText(this,"location",Toast.LENGTH_SHORT).show()
                  // navigationView.getMenu().getItem(3).setVisible(false);
                   true

               }else->{true}



           }
//           var manager=supportFragmentManager
//           manager.beginTransaction().replace(R.id.fragment_container,fragment as Fragment).commit();

           it.setChecked(true)
           drawer.closeDrawers()
           true


       }

    }
    fun hidemenu(){
        var menu=navigationView.menu;
        menu.findItem(R.id.login).setVisible(false);
    }
//    fun visiblemenu(){
//        var menu=navigationView.menu;
//        menu.findItem(R.id.login).isVisible=true;
//    }
    fun init(){
        toolbar=findViewById(R.id.toolbar)
        drawer=findViewById(R.id.drawerLayout)
        navigationView=findViewById(R.id.navigationView)
        frameLayout=findViewById(R.id.fragment_container)



    }


}