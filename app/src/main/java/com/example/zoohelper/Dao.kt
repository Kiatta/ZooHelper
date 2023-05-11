package com.example.zoohelper
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {
    @Insert
    fun insertAnimal(animal: Animal)
    @Query("SELECT * FROM Animal")
    fun getAllAnimal(): LiveData<List<Animal>>
    @Query("DELETE FROM Animal WHERE id = :animal_id")
    suspend fun deleteAnimal(animal_id: Int)
    @Query("UPDATE Animal SET status = :status WHERE id = :animal_id")
    suspend fun switchAnimal(status: Boolean,animal_id: Int)
    @Query("SELECT * FROM Animal WHERE status = :status")
    fun getBol(status: Boolean): LiveData<List<Animal>>
    @Query("SELECT * FROM Animal WHERE status = 1")
    fun getZdor(): LiveData<List<Animal>>
}