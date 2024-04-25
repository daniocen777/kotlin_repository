package com.danicode.basic.todo

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.danicode.basic.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val vDivider: View = view.findViewById(R.id.vDivider)
    private val viewCategoryContainer: CardView = view.findViewById(R.id.viewCategoryContainer)


    // Recibe onItemSelected (lambda)
    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit) {
        // Para el filtrado
        itemView.setOnClickListener {
            val color = if (taskCategory.isSelected) {
                R.color.todo_background_card
            } else {
                R.color.todo_background_disabled
            }
            viewCategoryContainer.setCardBackgroundColor(
                ContextCompat.getColor(
                    viewCategoryContainer.context,
                    color
                )
            )

            onItemSelected(layoutPosition)
        }
        when (taskCategory) {
            TaskCategory.Business -> {
                tvCategoryName.text = "Negocios"
                vDivider.setBackgroundColor(
                    ContextCompat.getColor(
                        vDivider.context,
                        R.color.todo_business_category
                    )
                )
            }
            TaskCategory.Other -> {
                tvCategoryName.text = "Otros"
                vDivider.setBackgroundColor(
                    ContextCompat.getColor(
                        vDivider.context,
                        R.color.todo_other_category
                    )
                )
            }
            TaskCategory.Personal -> {
                tvCategoryName.text = "Personal"
                vDivider.setBackgroundColor(
                    ContextCompat.getColor(
                        vDivider.context,
                        R.color.todo_personal_category
                    )
                )
            }
        }
    }
}