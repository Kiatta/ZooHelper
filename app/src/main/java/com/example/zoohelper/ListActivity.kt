package com.example.zoohelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zoohelper.adapter.MyAdapter
import com.example.zoohelper.fragment.AddFragment
import com.example.zoohelper.fragment.AnimalsFragment
import com.example.zoohelper.fragment.WeatherFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class ListActivity() : AppCompatActivity() {

    private lateinit var container: FrameLayout
    private lateinit var navigation: BottomNavigationView
    lateinit var viewmodel: AnimalViewModel
    private lateinit var db: MainDb

    lateinit var adapter: MyAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        val profession = intent.getBooleanExtra("profession",false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        viewmodel = AnimalViewModel(applicationContext, profession)
        adapter  = MyAdapter(kotlin.collections.listOf(), viewmodel)
        viewmodel.myLiveData.observe(this){
            adapter.animal = it
            adapter.notifyDataSetChanged()
        }
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
                R.id.nav_add -> {
                    showFragment(AddFragment())
                    true
                }
                else -> false
            }
        }


        showFragment(AnimalsFragment())
    }


    fun onDeleteSelectedClick(view: View) {

    }
    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}
