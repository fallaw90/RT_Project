package com.fallntic.rt_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.fallntic.rt_project.Fragments.MostViewed
import com.fallntic.rt_project.Fragments.Recent
import com.fallntic.rt_project.Fragments.TopRated
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView : BottomNavigationView
    private lateinit var fragment: Fragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_nav)

        bottomNavigationView.setOnNavigationItemSelectedListener(itemListener)

    }

    private var itemListener = BottomNavigationView.OnNavigationItemSelectedListener {menuItem ->
        when(menuItem.itemId){
            R.id.top_rated -> {
                 fragment = TopRated()
            }
            R.id.most_viewed -> {
                fragment = MostViewed()
            }
            R.id.recents -> {
                fragment = Recent()
            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
        return@OnNavigationItemSelectedListener true
    }
}
