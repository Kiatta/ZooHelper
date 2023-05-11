package com.example.zoohelper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.zoohelper.Animal
import com.example.zoohelper.AnimalViewModel
import com.example.zoohelper.ListActivity
import com.example.zoohelper.R
import com.example.zoohelper.databinding.ListItemBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MyAdapter(var animal: List<Animal>, var viewModel: AnimalViewModel): RecyclerView.Adapter<MyAdapter.Holder>() {
    fun onDeleteButtonClick(itemView: View) {
        itemView.findViewById<Button>(R.id.buttonDelete).setOnClickListener {
            val id = itemView.findViewById<TextView>(R.id.textViewID).text.toString().toInt()
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.deleteAnimal(id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)



        return Holder(view)
    }



    inner class Holder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ListItemBinding.bind(view)
        lateinit var viewmodel: AnimalViewModel


        fun bind(item: Animal) = with(binding){
            textViewID.text = item.id.toString()
            textViewTitle.text = item.name
            textViewWeight.text = item.weight.toString()
            textViewAge.text = item.age.toString()
            textViewHabitat.text = item.habitat
            Picasso.get().load(item.photoUrl).into(imageViewAnimal)
            try {
                onDeleteButtonClick(itemView)
            }catch (e: android.database.SQLException)
            {

            }




        }


    }



    class Comparator : DiffUtil.ItemCallback<Animal>(){
        override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem == newItem
        }

    }



    override fun onBindViewHolder(holder: Holder, position: Int) {
        val animal = animal[position]
        holder.bind(animal)
    }
    override fun getItemCount(): Int {
        return animal.size
    }

}
