package com.danicode.users_shared_preferent

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danicode.users_shared_preferent.databinding.ItemUserBinding

// Adapter que recibe la lista de usuarios
// UserAdapter.ViewHolder => Personalizado (clase interna que está al final)
class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private lateinit var context: Context // nunca es null

    // Sobreescribir 3 métodos (control + i)
    // onCreateViewHolder => Inflar la vista con el xml. Solo crea la vista (no rellena de info)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inicializar context
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    // Rellenar con datos => como un foreach
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users.get(position)
        with(holder) {
            binding.tvOrder.text = user.id.toString()
            binding.tvName.text = user.name
        }
    }

    // Indica la cantidad de elementos
    override fun getItemCount(): Int = users.size

    // Clase interna
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        /** Agregar al gradle:
         * buildFeatures {
        viewBinding true
        }
         * */
        val binding = ItemUserBinding.bind(view) // vincular la vista a este adapter
    }
}