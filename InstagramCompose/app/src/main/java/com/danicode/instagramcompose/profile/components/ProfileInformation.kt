package com.danicode.instagramcompose.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage

@Composable
fun ProfileInformation(
    imageUrl: String,
    posts: Int,
    followers: Int,
    followings: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Image
        AsyncImage(
            model = imageUrl,
            contentDescription = "Profile Image",
            modifier = Modifier.clip(CircleShape)
        )
        // Publications
        ProfileInformationItem(amount = posts, type = "Publications")
        // Followers
        ProfileInformationItem(amount = followers, type = "Followers")
        // Followings
        ProfileInformationItem(amount = followings, type = "Followings")
    }
}

@Composable
private fun ProfileInformationItem(amount: Int, type: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = amount.toString(), fontWeight = FontWeight.Bold)
        Text(text = type)
    }
}

@Preview
@Composable
fun ProfileInformationPreview() {
    ProfileInformation("", 1, 1, 1)
}