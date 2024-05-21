package com.danicode.marveluniverseclean.ui.charactersList.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.danicode.marveluniverseclean.databinding.ItemCharacterBinding
import com.danicode.marveluniverseclean.domain.model.Character
import com.squareup.picasso.Picasso
import kotlin.math.log

class CharactersListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val mBinding = ItemCharacterBinding.bind(view)

    fun render(character: Character) {
        mBinding.tvCharacter.text = character.name
        val imageUrl = "${character.thumbnail}/portrait_xlarge.${character.thumbnailExt}"
        Log.i("CharactersListViewHolder", imageUrl)

        Picasso.get().load(imageUrl).into(mBinding.ivCharacter)
        mBinding.root.setOnClickListener {
            Log.i("SUPERHERO", character.name)
        }
    }
}