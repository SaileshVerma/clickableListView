package com.example.secondapp.imageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.FrameLayout
import androidx.viewpager.widget.ViewPager
import com.example.secondapp.R
import com.google.android.material.tabs.TabLayout

class ImageSliderActivity : AppCompatActivity() {
    private lateinit var viewpager:ViewPager
    private lateinit var pagerAdapter:PagerAdapter
    private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_slider)
        init()
        pagerAdapter=PagerAdapter(supportFragmentManager);
        viewpager.adapter=pagerAdapter;
       tabLayout.setupWithViewPager(viewpager);
    }




    fun init(){
        viewpager=findViewById(R.id.viewpager);
  tabLayout=findViewById(R.id.tablayout)
    }
}