package com.dev.topefirstapplication.ui.inventory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dev.topefirstapplication.R

class InventoryFragment : Fragment() {

    private lateinit var inventoryViewModel: InventoryViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        inventoryViewModel =
                ViewModelProvider(this).get(InventoryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_inventory, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        inventoryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}