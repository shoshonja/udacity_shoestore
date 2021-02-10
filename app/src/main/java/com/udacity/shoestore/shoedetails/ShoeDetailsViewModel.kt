package com.udacity.shoestore.shoedetails

import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailsViewModel : ViewModel() {

    val eventCanceled: LiveData<Boolean>
        get() = _eventCanceled

    private val _eventCanceled = MutableLiveData<Boolean>()

    val eventSaved: LiveData<Boolean>
        get() = _eventSaved

    private val _eventSaved = MutableLiveData<Boolean>()

    fun onSave() {
        _eventSaved.value = true
    }

    fun onCancel() {
        _eventCanceled.value = true
    }

    fun handleEmptyEditTexts(editTextString: String): String {
        return editTextString ?: ""
    }

    fun handleEmptyEditTextsAsDoubles(editTextString: String): Double {
        return if (editTextString == ""){
            0.0
        } else {
            editTextString.toDouble()
        }
    }


}