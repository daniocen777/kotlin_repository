package com.danicode.basic.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danicode.basic.R

// Adapter con un lambda para filtrar las tareas por categoria
class CatagoriesAdapter(
    private val categories: List<TaskCategory>,
    private val onItemSelected: (Int) -> Unit
) :
    RecyclerView.Adapter<CategoriesViewHolder>() {
    // Crear la vista (layout item_task_category)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        // inflador de vista
        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_task_category,
                parent,
                false
            )
        return CategoriesViewHolder(view)
    }

    override fun getItemCount(): Int = categories.size


    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(categories[position], onItemSelected)
    }

}