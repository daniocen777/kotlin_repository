package com.danicode.instagramcompose.profile.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfileAction(
    followClick: () -> Unit,
    messageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxWidth()) {
        ProfileActionButton(
            onClick = followClick,
            text = "Follower",
            modifier = modifier.weight(1f)
        )
        Spacer(modifier = modifier.width(8.dp))
        ProfileActionButton(
            onClick = messageClick,
            text = "Message",
            modifier = modifier.weight(1f)
        )
    }
}

@Composable
private fun ProfileActionButton(onClick: () -> Unit, text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
    ) {
        Text(text = text, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun ProfileActionPreview() {
    ProfileAction({}, {})
}