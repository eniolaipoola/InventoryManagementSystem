package com.dev.topefirstapplication.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dev.topefirstapplication.R


class ProductAdapter(var listener: OnProductSelectedListener):
    RecyclerView.Adapter<ProductAdapter.CoursesViewHolder>() {

    var allProduct = ArrayList<ProductModel>()

    fun setProductItem(coursesData: List<ProductModel>){
        allProduct.clear()
        allProduct.addAll(coursesData)
        notifyDataSetChanged()
    }

    class CoursesViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val productName: TextView = view.findViewById(R.id.product_name)
        val productPrice: TextView = view.findViewById(R.id.product_price)
        val productBarCode:TextView = view.findViewById(R.id.product_barcode)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
         return CoursesViewHolder (
            LayoutInflater.from(parent.context).inflate(R.layout.item_store_product_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        val item = allProduct[position]
        holder.productName.text = item.name
        holder.productPrice.text = item.amount.toString()
        holder.productBarCode.text = item.barcode
        /*holder.productBarCode.setOnClickListener {
            listener.onCourseSelected(item, it)
        }*/

    }

    override fun getItemCount(): Int {
        return allProduct.size
    }

    interface OnProductSelectedListener {
        fun onProductSelected(item: ProductModel, view: View)
    }
}