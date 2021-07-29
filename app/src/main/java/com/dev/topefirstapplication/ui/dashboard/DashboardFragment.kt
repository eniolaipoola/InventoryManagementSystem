package com.dev.topefirstapplication.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.topefirstapplication.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DashboardFragment : Fragment(), ProductAdapter.OnProductSelectedListener {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {

        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val fab: FloatingActionButton = root.findViewById(R.id.create_item_fab)
        fab.setOnClickListener {
            val dialogFragment: DialogFragment =
                CreateProductDialogFragment()
            //dialogFragment.arguments = bundle
            activity?.supportFragmentManager?.let { it1 -> dialogFragment.show(it1, "addProductDialog") }
        }

        dashboardViewModel.allData.observe(viewLifecycleOwner, Observer {
            //insert all products into database
            productAdapter = ProductAdapter(this)
            productAdapter.setProductItem(it)
            linearLayoutManager = LinearLayoutManager(
                    requireActivity().applicationContext,
                    LinearLayoutManager.VERTICAL, false
            )
            val categoryValue: TextView = root.findViewById(R.id.number_of_items_value)
            categoryValue.text = it.size.toString()
            //populate data
            val productRecyclerView: RecyclerView = root.findViewById(R.id.items_recycler_view)
            productRecyclerView.adapter = productAdapter
            productRecyclerView.layoutManager = linearLayoutManager
        })

        val categoryText: TextView = root.findViewById(R.id.category_text)
        categoryText.setOnClickListener {
            //navigate to category page
            findNavController().navigate(R.id.navigation_category)
        }

        return root
    }

    override fun onProductSelected(item: ProductModel, view: View) {}
}