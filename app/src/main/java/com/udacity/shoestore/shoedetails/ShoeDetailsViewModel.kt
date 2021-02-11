package com.udacity.shoestore.shoedetails

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailsViewModel : ViewModel() {

    val newShoe: LiveData<Shoe>
        get() = _newShoe

    private val _newShoe = MutableLiveData<Shoe>()

    val eventCanceled: LiveData<Boolean>
        get() = _eventCanceled

    private val _eventCanceled = MutableLiveData<Boolean>()


    val name = ObservableField<String>()
    val manufacturer = ObservableField<String>()
    val size = ObservableField<String>()
    val description = ObservableField<String>()


    fun onSave() {
        _newShoe.value = Shoe(
            handleEmptyEditTexts(name.get()),
            handleEmptyEditTextsAsDoubles(size.get()),
            handleEmptyEditTexts(manufacturer.get()),
            handleEmptyEditTexts(description.get())
        )
    }

    fun onCancel() {
        _eventCanceled.value = true
    }

    private fun handleEmptyEditTexts(editTextString: String?): String {
        return editTextString ?: ""
    }

    private fun handleEmptyEditTextsAsDoubles(editTextString: String?): Double {
        return editTextString?.toDouble() ?: 0.0
    }
}