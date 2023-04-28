package com.example.zoohelper.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zoohelper.AnimalDatabaseHelper
import com.example.zoohelper.Animals
import com.example.zoohelper.R
import com.example.zoohelper.adapter.MyAdapter
import com.example.zoohelper.databinding.FragmentAnimalsBinding

class AnimalsFragment : Fragment() {

    private lateinit var binding: FragmentAnimalsBinding
    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }

    private fun initRcView() = with(binding){
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = MyAdapter()
        recyclerView.adapter = adapter
        val list = listOf(
            Animals(
                1,"Obezyana",
                25,5,
                "", false, "https://mykaleidoscope.ru/x/uploads/posts/2022-09/1663131939_18-mykaleidoscope-ru-p-zloi-yenot-vkontakte-18.jpg"),
            Animals(
                2,"Tigr",
                35,2,
                "", false, "https://mykaleidoscope.ru/x/uploads/posts/2022-09/1663131939_18-mykaleidoscope-ru-p-zloi-yenot-vkontakte-18.jpg"),
            Animals(
                3,"Lev",
                15,3,
                "", true, ""),
            Animals(
                4,"Tigr",
                35,2,
                "", false, ""),
            Animals(
                5,"Tigr",
                35,2,
                "", false, ""),
            Animals(
                6,"Tigr",
                35,2,
                "", false, ""),
            Animals(
                7,"Tigr",
                35,2,
                "", false, ""),
            Animals(
                8,"Tigr",
                35,2,
                "", false, ""),
            Animals(
                9,"Tigr",
                35,2,
                "", false, ""),

        )
        adapter.submitList(list)
    }
    companion object {
        @JvmStatic
        fun newInstance() = AnimalsFragment()
    }

}