package com.example.zoohelper

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AnimalDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Kotlin.db"
        private const val TABLE_NAME = "Animal"
        private const val COLUMN_ID = "animal_id"
        private const val COLUMN_NAME = "animal_name"
        private const val COLUMN_WEIGHT = "animal_weight"
        private const val COLUMN_AGE = "animal_age"
        private const val COLUMN_HABITAT = "animal_habitat"
        private const val COLUMN_STATUS = "animal_status"
        private const val COLUMN_PHOTO = "animal_photo"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_NAME TEXT, $COLUMN_WEIGHT INTEGER, $COLUMN_AGE INTEGER, $COLUMN_HABITAT TEXT, $COLUMN_STATUS INTEGER, $COLUMN_PHOTO TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    @SuppressLint("Range")
    fun getAnimals(): List<Animals> {
        val animals = mutableListOf<Animals>()
        val db = writableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                val weight = cursor.getInt(cursor.getColumnIndex(COLUMN_WEIGHT))
                val age = cursor.getInt(cursor.getColumnIndex(COLUMN_AGE))
                val habitat = cursor.getString(cursor.getColumnIndex(COLUMN_HABITAT))
                val status = cursor.getInt(cursor.getColumnIndex(COLUMN_STATUS)) > 0
                val photoUrl = cursor.getString(cursor.getColumnIndex(COLUMN_PHOTO))
                val animal = Animals(id, name, weight, age, habitat, status, photoUrl)
                animals.add(animal)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return animals
    }
}
