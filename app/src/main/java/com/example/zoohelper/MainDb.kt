package com.example.zoohelper
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Database


@Database(entities = [Animal::class], version = 1)
abstract class MainDb(): RoomDatabase() {

    abstract fun getDao(): Dao

    companion object{
        fun getDB(context: Context): MainDb{
            return Room.databaseBuilder(
                context.applicationContext,
                MainDb::class.java,
                "Animal.db"
            ).build()
        }

    }
}