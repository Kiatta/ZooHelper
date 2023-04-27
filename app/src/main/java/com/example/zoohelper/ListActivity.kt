package com.example.zoohelper

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.zoohelper.fragment.AnimalsFragment
import com.example.zoohelper.fragment.ListFragment
import com.example.zoohelper.fragment.WeatherFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ListActivity : AppCompatActivity() {

    private lateinit var container: FrameLayout
    private lateinit var navigation: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        container = findViewById(R.id.container)
        navigation = findViewById(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_weather -> {
                    showFragment(WeatherFragment())
                    true
                }
                R.id.navigation_animals -> {
                    showFragment(AnimalsFragment())
                    true
                }
                else -> false
            }
        }

        // Показываем фрагмент с погодой по умолчанию
        showFragment(WeatherFragment())
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}
