package com.example.zoohelper

import androidx.lifecycle.LiveData

class AnimalRepository(private val dao: Dao) {

    val allAnimals: LiveData<List<Animal>> = dao.getAllAnimal()

    suspend fun insertAnimal(animal: Animal) {
        dao.insertAnimal(animal)
    }

    suspend fun deleteAnimal(animalId: Int) {
        dao.deleteAnimal(animalId)
    }
}
