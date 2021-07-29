package com.dev.topefirstapplication.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CategoryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text


    private val _allCategory = MutableLiveData<ArrayList<CategoryModel>>().apply {
        val allCategory = ArrayList<CategoryModel>()
        allCategory.add(
            CategoryModel("1", "Provisions", "21-06-2021", "21-06-2021", 3
        ))
        allCategory.add(
            CategoryModel("2", "Toiletries", "21-06-2021", "21-06-2021", 3
            ))
        allCategory.add(
            CategoryModel("3", "Food Item", "21-06-2021", "21-06-2021", 3
            ))
        allCategory.add(
            CategoryModel("4", "Drinks", "21-06-2021", "21-06-2021", 3
            ))
        allCategory.add(
            CategoryModel("5", "Clothing Item", "21-06-2021", "21-06-2021", 3
            ))
        value = allCategory
    }

    val categoryData: LiveData<ArrayList<CategoryModel>> = _allCategory


}