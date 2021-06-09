package com.example.secondapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

class ListViewActivity : AppCompatActivity() {
    private lateinit var listviewlayout:ListView
    private lateinit var namesList:ArrayList<Name>
    private lateinit var adapter:MyAdapter
 private lateinit var temp:ArrayList<String>;
    fun init(){
        listviewlayout=findViewById(R.id.listviewlayout)


    }

    fun initdata(){


        namesList= ArrayList()
        namesList.add(Name("sailesh"))
        namesList.add(Name("ramgopal"))
        namesList.add(Name("rohan"))
        namesList.add(Name("yara"))
        namesList.add(Name("sailesh"))
        namesList.add(Name("ramgopal"))
        namesList.add(Name("rohan"))
        namesList.add(Name("yara"))
        namesList.add(Name("sailesh"))
        namesList.add(Name("ramgopal"))
        namesList.add(Name("rohan"))

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
                 init()
                  initdata()
        adapter=MyAdapter(this,namesList)
        listviewlayout.adapter=adapter

        listviewlayout.setOnItemClickListener{

                parent,view, position, id ->


            var data=namesList.get(position);

           var bundle=Bundle()
              bundle.putString("name",data.name)
                val intent = Intent(this, MainActivity::class.java)
            intent.putExtras(bundle);
                startActivity(intent)
            }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         super.onCreateOptionsMenu(menu)

        menuInflater.inflate(R.menu.menubar,menu)
        return true;


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.add->{true}
            R.id.delete->{true}
            R.id.exit->{
                finish()
                true}



            else-> super.onOptionsItemSelected(item)
        }



    }


}