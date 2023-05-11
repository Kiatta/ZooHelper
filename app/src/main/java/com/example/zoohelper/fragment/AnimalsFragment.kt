package com.example.zoohelper.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zoohelper.*
import com.example.zoohelper.adapter.MyAdapter
import com.example.zoohelper.databinding.ActivityListBinding
import com.example.zoohelper.databinding.FragmentAnimalsBinding
import com.example.zoohelper.databinding.ListItemBinding
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnimalsFragment: Fragment() {

    private lateinit var binding: FragmentAnimalsBinding
    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var db: MainDb
    private lateinit var viewModel: AnimalViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_animals, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        return view

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initRcView()

    }
    private fun initRcView() {
        db = MainDb.getDB(requireContext())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = (activity as ListActivity).adapter

    }



    companion object {
        @JvmStatic
        fun newInstance() = AnimalsFragment()
    }

}