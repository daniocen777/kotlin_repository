package com.danicode.marveluniverseclean.domain.model

data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: String, // miniatura
    val thumbnailExt: String, // extension
    val comics: List<String>
)
