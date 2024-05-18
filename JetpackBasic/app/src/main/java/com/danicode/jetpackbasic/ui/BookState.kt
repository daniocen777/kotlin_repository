package com.danicode.jetpackbasic.ui

data class BookState(val books: List<Book> = emptyList(), val isLoading: Boolean = false)
