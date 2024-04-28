package com.danicode.users_shared_preferent

// Data Class => Para más propiedades
data class User(val id: Long, var name: String, var lastname: String, var url: String) {
    fun getFullName(): String = "$name $lastname"
}