package com.example.zoohelper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.zoohelper.Animal
import com.example.zoohelper.AnimalViewModel
import com.example.zoohelper.R
import com.example.zoohelper.databinding.ListItemBinding
import com.example.zoohelper.fragment.AnimalsFragment
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class MyAdapter(var animal: List<Animal>, private var viewModel: AnimalViewModel, private var animalsFragment: AnimalsFragment): RecyclerView.Adapter<MyAdapter.Holder>() {

    class Holder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ListItemBinding.bind(view)

        fun bind(item: Animal) = with(binding){
            textViewTitle.text = item.name
            textViewWeight.text = item.weight.toString()
            textViewAge.text = item.age.toString()
            textViewHabitat.text = item.habitat
            Picasso.get().load(item.photoUrl).into(imageViewAnimal)

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val animal = animal[position]
        holder.bind(animal)
    }
    override fun getItemCount(): Int {
        return animal.size
    }

}
