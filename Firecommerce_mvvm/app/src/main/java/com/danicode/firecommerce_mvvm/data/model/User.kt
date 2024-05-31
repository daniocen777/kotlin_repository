package com.danicode.firecommerce_mvvm.data.model

data class User(
    val firstname: String,
    val lastname: String,
    val email: String,
    val imagePath: String = ""
) {
    // Constructor para firebase
    constructor() : this("", "", "", "")
}
