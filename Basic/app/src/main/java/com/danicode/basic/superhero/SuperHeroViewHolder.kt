package com.danicode.basic.superhero

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.danicode.basic.databinding.ItemSuperHeroBinding
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperHeroBinding.bind(view)

    fun bind(heroItemResponse: HeroItemResponse, onItemSelected: (String) -> Unit) {
        binding.tvHeroName.text = heroItemResponse.title
        // En gradle => implementation 'com.squareup.picasso:picasso:2.8'
        Picasso.get().load(heroItemResponse.poster).into(binding.ivHero)
        binding.root.setOnClickListener {
            onItemSelected(heroItemResponse.imdbID)
        }
    }
}