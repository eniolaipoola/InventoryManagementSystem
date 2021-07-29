package com.dev.topefirstapplication.ui.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dev.topefirstapplication.R


class CategoryAdapter(var listener: OnCategorySelectedListener):
    RecyclerView.Adapter<CategoryAdapter.CoursesViewHolder>() {

    var category = ArrayList<CategoryModel>()

    fun setProductItem(categoryData: List<CategoryModel>){
        category.clear()
        category.addAll(categoryData)
        notifyDataSetChanged()
    }

    class CoursesViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val categoryName: TextView = view.findViewById(R.id.category_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
         return CoursesViewHolder (
            LayoutInflater.from(parent.context).inflate(R.layout.item_store_category_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        val item = category[position]
        holder.categoryName.text = item.name
        /*holder.productBarCode.setOnClickListener {
            listener.onCourseSelected(item, it)
        }*/

    }

    override fun getItemCount(): Int {
        return category.size
    }

    interface OnCategorySelectedListener {
        fun onCategorySelected(item: CategoryModel, view: View)
    }
}