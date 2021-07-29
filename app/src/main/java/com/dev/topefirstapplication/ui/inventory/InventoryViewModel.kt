package com.dev.topefirstapplication.ui.inventory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InventoryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Put selected items here and calculate total price"
    }
    val text: LiveData<String> = _text
}