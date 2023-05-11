package com.example.zoohelper

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

 class AnimalViewModel(context: Context,profession: Boolean): ViewModel() {

    private  var _myLiveData: LiveData<List<Animal>>
    private var db :MainDb

    init {
        db = MainDb.getDB(context)
        _myLiveData = db.getDao().getBol(profession)


    }
    val myLiveData: LiveData<List<Animal>>
    get() = _myLiveData

     fun deleteAnimal(id: Int) {
         viewModelScope.launch(Dispatchers.IO){
            db.getDao().deleteAnimal(id)
        }
    }
     fun request() {
         viewModelScope.launch {
             db.getDao().getAllAnimal()
         }
     }
     fun switch(status:Boolean,id: Int) {
         viewModelScope.launch(Dispatchers.IO) {
             db.getDao().switchAnimal(status,id)
         }
     }


}