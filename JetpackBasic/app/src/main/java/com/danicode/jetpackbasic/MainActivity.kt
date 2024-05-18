package com.danicode.jetpackbasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bookViewModel by viewModels<BookViewModel>()

        setContent {
            // MainScreen(MainViewModel())
            MainScreen(bookViewModel)
        }
    }
}

// fun MainScreen(viewModel: MainViewModel) {
@Composable
fun MainScreen(bookViewModel: BookViewModel) {
    /* Text(
         text = "Holas Holas  Holas Holas Holas Holas Holas Holas",
         color = Color.Cyan,
         fontSize = 22.sp,
         fontStyle = FontStyle.Italic,
         fontWeight = FontWeight.Bold,
         fontFamily = FontFamily.Cursive,
         letterSpacing = 3.sp,
         overflow = TextOverflow.Ellipsis,
         maxLines = 1
     )*/

    /*Button(onClick = {
        Log.i("MainScreen", "Botón apretado")
    }) {
        // Para colocar un texto, se necesita el componet¿nte text
        Column {
            Text(text = "Click me")
            Text(text = "Click me 2")
        }
    }*/

    /*Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Post")
        Text(text = "Followers")
        Text(text = "Followings")
    }*/
    // Box => Superpuesto
    /*Box(modifier = Modifier
        .size(300.dp)
        .clickable { Log.i("MainScreen", "Click text") }
        .padding(20.dp)) {
        Greetings()
    }*/

    // Cambiar estados => Remember, recuerda un estado antes de recomponer el composable
    /*var name by remember {
        mutableStateOf("Pedro")
    }
    DisplayName(name) {
        name = "Juan"
    }*/
    /* DisplayName(name = viewModel.state) {
         viewModel.updateName()
     }*/

    // INPUTS => TextField no maneja sus propios estados
    /*var name by remember {
        mutableStateOf("")
    }

    var currentName by remember {
        mutableStateOf("Pedro")
    }

    Column() {
        Text(text = currentName)
        TextField(value = name, onValueChange = {
            name = it
        })
        Button(onClick = {
            if (name.isNotBlank()) {
                currentName = name
            }
        }) {
            Text(text = "Click me!")
        }
    }*/

    // LISTA DE NOMBRES
    /*val names = (0..200).map { "$it - Danicode" }
    *//*Column() {
        for (name in names) {
            Text(text = name)
        }
    }*//*
    // Scrollable
    LazyColumn() {
        item {
            Text(text = "Nombres:")
        }
        *//*items(names) { name ->
            // Text(text = name)
            NameItem(name)
        }*//*

        itemsIndexed(names) { index, name ->
            if (index % 2 == 0) {
                NameItem(name)
            } else {
                NameItem2(name)
            }
        }
    }*/


    // BOOKS
    val state = bookViewModel.state

    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    if (state.books.isEmpty()) {
        Text(text = "No hay libros", style = MaterialTheme.typography.h1)
    }

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(state.books) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { bookViewModel.deleteBookClick(it) }) {
                Text(text = it.title, style = MaterialTheme.typography.body1)
                Text(text = it.author, style = MaterialTheme.typography.body2)
                Divider()
            }
        }
    }
}

/*
@Composable
fun NameItem2(name: String) {
    Button(onClick = { */
/*TOD*//*
 }) {
        Text(text = name, style = MaterialTheme.typography.body1, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun NameItem(name: String) {
    Text(text = name, style = MaterialTheme.typography.body1, fontWeight = FontWeight.Bold)
}

@Composable
fun DisplayName(name: String, onClick: () -> Unit) {
    Column() {
        Text(text = "Pedro")
        Button(onClick = onClick) {
            Text(text = "Cambiar nombre")
        }
    }
}

@Composable
fun Greetings() {
    // fillMaxSize = ocupa toda la pantaal del padre
    Text(text = "Holas mundos perdidos", modifier = Modifier.fillMaxSize())
}

@Preview
@Composable
fun preview() {
    // MainScreen(bookViewModel)
}*/
