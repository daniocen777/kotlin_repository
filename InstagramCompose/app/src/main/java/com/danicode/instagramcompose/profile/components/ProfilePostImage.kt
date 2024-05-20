package com.danicode.instagramcompose.profile.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
fun ProfilePostImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        AsyncImage(model = imageUrl, contentDescription = "user post")
    }
}