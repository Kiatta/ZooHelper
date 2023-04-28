package com.example.zoohelper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.zoohelper.Animals
import com.example.zoohelper.R
import com.example.zoohelper.databinding.ListItemBinding

class MyAdapter : ListAdapter<Animals, MyAdapter.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ListItemBinding.bind(view)

        fun bind(item: Animals) = with(binding){
            textViewTitle.text = item.name
            textViewWeight.text = item.weight.toString()
            textViewAge.text = item.age.toString()
            textViewHabitat.text = item.habitat
        }
    }
    class Comparator : DiffUtil.ItemCallback<Animals>(){
        override fun areItemsTheSame(oldItem: Animals, newItem: Animals): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Animals, newItem: Animals): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}
