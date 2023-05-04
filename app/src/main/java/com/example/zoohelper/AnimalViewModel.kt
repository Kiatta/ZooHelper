package com.example.zoohelper

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

 class AnimalViewModel(context: Context): ViewModel() {

    private  var _myLiveData: LiveData<List<Animal>>
    private var db = MainDb.getDB(context)

    init {

        _myLiveData = db.getDao().getAllAnimal()


    }
    val myLiveData: LiveData<List<Animal>>
    get() = _myLiveData

     fun deleteAnimal(id: Int) {
        viewModelScope.launch {
            db.getDao().deleteAnimal(id)
        }
    }


}