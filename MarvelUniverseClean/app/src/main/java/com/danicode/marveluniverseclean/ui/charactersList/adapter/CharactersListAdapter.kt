package com.danicode.marveluniverseclean.ui.charactersList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danicode.marveluniverseclean.R
import com.danicode.marveluniverseclean.domain.model.Character

class CharactersListAdapter(private var charactersList: List<Character> = emptyList()) :
    RecyclerView.Adapter<CharactersListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersListViewHolder {
        return CharactersListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_character, parent, false)
        )
    }

    override fun getItemCount(): Int = charactersList.size

    override fun onBindViewHolder(holder: CharactersListViewHolder, position: Int) {
        holder.render(charactersList[position])
    }

    // Otras funciones
    fun setData(list: List<Character>) {
        charactersList = list
        notifyDataSetChanged()
    }
}
