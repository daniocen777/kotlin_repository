package com.danicode.marveluniverseclean.data.data_source.dto

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)