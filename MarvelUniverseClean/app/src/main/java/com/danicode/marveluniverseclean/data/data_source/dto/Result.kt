package com.danicode.marveluniverseclean.data.data_source.dto

import com.danicode.marveluniverseclean.domain.model.Character

data class Result(
    val comics: Comics,
    val description: String,
    val events: Events,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val urls: List<Url>
) {
    fun toCharacter(): Character {
        return Character(
            id = this.id,
            name = this.name,
            description = this.description,
            thumbnail = this.thumbnail.path,
            thumbnailExt = this.thumbnail.extension,
            comics = comics.items.map { it.name }
        )
    }
}