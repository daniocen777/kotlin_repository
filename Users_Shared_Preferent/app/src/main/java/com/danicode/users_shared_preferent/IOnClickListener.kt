package com.danicode.users_shared_preferent

// Para el evento click de los items
interface IOnClickListener {
    fun onClick(user: User, position: Int)
}