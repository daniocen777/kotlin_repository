package com.danicode.instagramcompose.profile.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfileHeader(
    backClick: () -> Unit,
    notificationClick: () -> Unit,
    optionClick: () -> Unit,
    username: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = backClick) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "arrow back")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = username, fontWeight = FontWeight.Bold)
            }
        }
        ProfileHeaderOptions(notificationClick = notificationClick, optionClick = optionClick)
    }
}

@Composable
fun ProfileHeaderOptions(
    notificationClick: () -> Unit,
    optionClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        IconButton(onClick = notificationClick) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "notifications"
            )
        }
        IconButton(onClick = optionClick) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "options")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileHeader({}, {}, {}, "Danicode")
}