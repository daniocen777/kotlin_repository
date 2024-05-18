package com.danicode.jetpackbasic

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danicode.jetpackbasic.ui.Book
import com.danicode.jetpackbasic.ui.BookState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {
    // private set => MainScreen pueda acceder al estado, pero no modificarlos
    var state by mutableStateOf(BookState())
        private set

    init {
        // Corrutina
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            delay(2000)
            state = state.copy(
                books = listOf(
                    Book("Clean Code", "Robert C. Martin"),
                    Book("Refactoring", "Martin Flower"),
                    Book("Effective Java", "Joshua Bloch")
                ),
                isLoading = false
            )
        }
    }

    fun deleteBookClick(book: Book) {
        val index = state.books.indexOf(book)
        val updateBook = state.books.toMutableList()
        updateBook.removeAt(index)
        state = state.copy(
            books = updateBook
        )
    }
}