package com.example.zoohelper

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel:ViewModel() {
    val liveDataCurrent = MutableLiveData<WeatherModel>()
    val liveDataList = MutableLiveData<List<WeatherModel>>()
}