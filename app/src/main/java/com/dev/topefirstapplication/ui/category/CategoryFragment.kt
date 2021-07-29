package com.dev.topefirstapplication.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.topefirstapplication.R

class CategoryFragment : Fragment(), CategoryAdapter.OnCategorySelectedListener {

    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var layoutManager: GridLayoutManager
    lateinit var categoryAdapter: CategoryAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        categoryViewModel =
                ViewModelProvider(this).get(CategoryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_category, container, false)

        categoryViewModel.categoryData.observe(viewLifecycleOwner, Observer {
            //insert all category into database
            categoryAdapter = CategoryAdapter(this)
            categoryAdapter.setProductItem(it)
            layoutManager = GridLayoutManager(
                requireActivity().applicationContext, 3,
                LinearLayoutManager.VERTICAL, false
            )

            val categoryValue: TextView = root.findViewById(R.id.number_of_items_value)
            categoryValue.text = it.size.toString()
            //populate data
            val categoryRecyclerView: RecyclerView = root.findViewById(R.id.category_recycler_view)
            categoryRecyclerView.adapter = categoryAdapter
            categoryRecyclerView.layoutManager = layoutManager
        })

        return root
    }

    override fun onCategorySelected(item: CategoryModel, view: View) {}
}