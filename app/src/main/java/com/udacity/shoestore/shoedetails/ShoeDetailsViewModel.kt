package com.udacity.shoestore.shoedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailsViewModel : ViewModel() {

//    val newShoeDetail: LiveData<Shoe>
//        get() = _newShoeDetail
//    private val _newShoeDetail = MutableLiveData<Shoe>()

    val eventCanceled: LiveData<Boolean>
        get() = _eventCanceled

    private val _eventCanceled = MutableLiveData<Boolean>()

    val eventSaved: LiveData<Boolean>
    get() = _eventSaved

    private val _eventSaved = MutableLiveData<Boolean>()

    fun onSave() {
        _eventSaved.value = true
//        _newShoeDetail.value = shoe
    }

    fun onCancel() {
        _eventCanceled.value = true
//        _eventCanceled.value = false
    }

}