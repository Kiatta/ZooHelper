package com.example.zoohelper

import java.util.concurrent.locks.Condition

data class DayTime(
    val city: String,
    val date: String,
    val condition: String,
    val imageUrl: String,
    val currentTemp:String,
    val maxTemp:String,
    val minTemp:String,
    val hours:String

)
