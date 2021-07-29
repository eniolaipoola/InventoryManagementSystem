package com.dev.topefirstapplication.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    //create a function that fetched all items in my product table
    private val _allProduct = MutableLiveData<ArrayList<ProductModel>>().apply {
        val allProducts = ArrayList<ProductModel>()
        allProducts.add(ProductModel("1", "Milo", 3, "#CB1234",
            900.00, "21-05-2021", "21-05-2021", 3
        ))
        allProducts.add(ProductModel("2", "Groundnut oil", 3, "#CB1235",
            3000.00, "21-05-2021", "21-05-2021", 3
        ))
        allProducts.add(ProductModel("3", "Peak Milk", 3, "#CB1236",
            1200.00, "21-05-2021", "21-05-2021", 3
        ))
        allProducts.add(ProductModel("4", "Bournvita", 3, "#CB1237",
            1100.00, "21-05-2021", "21-05-2021", 3
        ))
        allProducts.add(ProductModel("5", "Spaghetini", 3, "#CB1238",
            300.00, "21-05-2021", "21-05-2021", 3
        ))
        allProducts.add(ProductModel("6", "Nivea Lotion", 3, "#CB1239",
            1600.00, "21-05-2021", "21-05-2021", 3
        ))
        allProducts.add(ProductModel("7", "Basmatic Rice", 3, "#CB1230",
            1550.00, "21-05-2021", "21-05-2021", 3
        ))
        allProducts.add(ProductModel("8", "Tomato Paste", 3, "#CB1222",
            200.00, "21-05-2021", "21-05-2021", 3
        ))
        value = allProducts
    }

    val allData: LiveData<ArrayList<ProductModel>> = _allProduct

}