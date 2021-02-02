package com.udacity.shoestore.activitymain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainActivityViewModel : ViewModel() {

    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    private val _shoeList = MutableLiveData<List<Shoe>>()

    private val realShoeList = ArrayList<Shoe>()

    fun addShoe(shoe: Shoe) {
        realShoeList.add(shoe)
        _shoeList.value = realShoeList
    }

}
