package com.example.zoohelper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import androidx.room.Dao
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    suspend fun insertAnimals(trans: Animal)
    @Query("SELECT * FROM Animal")
    fun getAllAnimals(): LiveData<List<Animal>>
    @Query("DELETE FROM Animal WHERE id = :animal_id")
    suspend fun deleteAnimal(animal_id: Int)

}