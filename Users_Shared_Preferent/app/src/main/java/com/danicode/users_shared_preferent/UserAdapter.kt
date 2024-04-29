package com.danicode.users_shared_preferent

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.danicode.users_shared_preferent.databinding.ItemUserAltBinding

// Adapter que recibe la lista de usuarios
// UserAdapter.ViewHolder => Personalizado (clase interna que está al final)
class UserAdapter(private val users: List<User>, private val listener: IOnClickListener) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private lateinit var context: Context // nunca es null

    // Sobreescribir 3 métodos (control + i)
    // onCreateViewHolder => Inflar la vista con el xml. Solo crea la vista (no rellena de info)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inicializar context
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_user_alt, parent, false)
        return ViewHolder(view)
    }

    // Rellenar con datos => como un foreach
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users.get(position)
        val personPosition: Int = position + 1
        with(holder) {
            // Funcion para hacer clic
            setListener(user, personPosition)
            binding.tvOrder.text = personPosition.toString()
            binding.tvName.text = user.getFullName()
            // Foto
            Glide.with(context)
                .load(user.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.ivPhoto)
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
        val binding = ItemUserAltBinding.bind(view) // vincular la vista a este adapter
        fun setListener(user: User, position: Int) {
            binding.root.setOnClickListener { listener.onClick(user, position) }
        }
    }
}