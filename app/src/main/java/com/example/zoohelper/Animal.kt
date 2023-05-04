package com.example.zoohelper

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Animal")
data class Animal(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "weight")
    var weight: Double,
    @ColumnInfo(name = "age")
    var age: Double,
    @ColumnInfo(name = "habitat")
    var habitat: String,
    @ColumnInfo(name = "status")
    var status: Boolean,
    @ColumnInfo(name = "photoUrl")
    var photoUrl: String


)