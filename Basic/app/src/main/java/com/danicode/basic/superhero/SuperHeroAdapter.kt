package com.danicode.basic.superhero

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danicode.basic.R

// Recibe una lambda para ir al detalle
class SuperHeroAdapter(
    var superHeroList: List<HeroItemResponse> = emptyList(),
    private val onItemSelected: (String) -> Unit
) :
    RecyclerView.Adapter<SuperHeroViewHolder>() {

    fun updateList(superHeroList: List<HeroItemResponse>) {
        this.superHeroList = superHeroList
        notifyDataSetChanged()
    }

    // Aqui se crea el layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_super_hero, parent, false))
    }

    // Para presentar los datos que ira en la vista segun su posicion
    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind(superHeroList[position], onItemSelected)
    }

    // Aqui se coloca el tamaño de la lista
    override fun getItemCount(): Int = superHeroList.size
}
