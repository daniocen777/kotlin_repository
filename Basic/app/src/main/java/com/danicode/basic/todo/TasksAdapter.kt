package com.danicode.basic.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danicode.basic.R

// TasksAdapter (lista, funcion_lambda que necesita un Int)
class TasksAdapter(var tasks: List<Task>, private val onTaskSelected: (Int) -> Unit) :
    RecyclerView.Adapter<TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_todo_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int = tasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.render(tasks[position])
        // Acceder a cada fila
        holder.itemView.setOnClickListener {
            // llamar a la funcion labnda
            onTaskSelected(position)
        }
    }
}