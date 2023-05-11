package com.example.zoohelper.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zoohelper.*
import com.example.zoohelper.adapter.MyAdapter
import com.example.zoohelper.databinding.ActivityAddBinding
import com.example.zoohelper.databinding.FragmentAnimalsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.sql.SQLException

class AddFragment: Fragment() {

    lateinit var adapter: MyAdapter
    private lateinit var animalViewModel: AnimalViewModel
    lateinit var binding: ActivityAddBinding
    lateinit var db: MainDb
    fun addDohod(animal: Animal): Job {
        return CoroutineScope(Job() + Dispatchers.IO).launch {
            try {
                db.getDao().insertAnimal(animal)
            } catch (e: SQLException) {
                println("Ошибка: ${e.message}")
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        animalViewModel = AnimalViewModel(requireContext(),false)
        adapter = MyAdapter(listOf(),animalViewModel)
        binding = ActivityAddBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = MainDb.getDB(requireContext())
        binding.buttonAddAnimal.setOnClickListener {
            try {
                val animal = Animal(
                    null,
                    binding.editTextName.text.toString(),
                    binding.editTextWeight.text.toString().toDouble(),
                    binding.editTextAge.text.toString().toDouble(),
                    binding.editTextHabitat.text.toString(),
                    binding.switchStatus.toString().toBoolean(),
                    binding.editTextPhotoUrl.toString()
                )
                addDohod(animal)
                CoroutineScope(Dispatchers.IO).launch {
                    animalViewModel.request()
                }
                binding.editTextName.setText("")
                binding.editTextWeight.setText("")
                binding.editTextAge.setText("")
                binding.editTextHabitat.setText("")
                binding.editTextPhotoUrl.setText("")
            }catch (e: NumberFormatException)
            {
                var toast = Toast.makeText(requireContext(),"Ошибка записи", Toast.LENGTH_LONG)
                toast.show()
            }

        }

    }

}