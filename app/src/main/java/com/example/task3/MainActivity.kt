package com.example.task3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.task3.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val favoriteFragment = FavoriteFragment()
        val heheFragment = HeheFragment()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_bar)

        replaceFragment(homeFragment)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.button_home -> replaceFragment(homeFragment)
                R.id.button_favorite -> replaceFragment(favoriteFragment)
                R.id.button_hehe -> replaceFragment(heheFragment)
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment !=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, fragment)
            transaction.commit()
        }
    }
}