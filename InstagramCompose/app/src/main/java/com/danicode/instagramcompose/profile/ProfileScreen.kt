package com.danicode.instagramcompose.profile

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danicode.instagramcompose.profile.components.*

@Composable
fun ProfileScreen() {
    val user = User(
        username = "Danicode",
        profileImageUrl = "https://freesvg.org/storage/img/thumb/1389952697.png",
        followers = 300,
        followings = 160,
        name = "Yonatan Daniel",
        description = "A big description",
        stories = listOf(
            Story(image = "https://freesvg.org/storage/img/thumb/1389952697.png", text = "Story 1"),
            Story(image = "https://freesvg.org/storage/img/thumb/1389952697.png", text = "Story 2"),
            Story(image = "https://freesvg.org/storage/img/thumb/1389952697.png", text = "Story 3"),
            Story(image = "https://freesvg.org/storage/img/thumb/1389952697.png", text = "Story 4"),
            Story(image = "https://freesvg.org/storage/img/thumb/1389952697.png", text = "Story 5"),
            Story(image = "https://freesvg.org/storage/img/thumb/1389952697.png", text = "Story 6"),
            Story(image = "https://freesvg.org/storage/img/thumb/1389952697.png", text = "Story 7"),
            Story(image = "https://freesvg.org/storage/img/thumb/1389952697.png", text = "Story 8"),
            Story(image = "https://freesvg.org/storage/img/thumb/1389952697.png", text = "Story 9"),
            Story(
                image = "https://freesvg.org/storage/img/thumb/1389952697.png",
                text = "Story 10"
            ),
            Story(image = "https://freesvg.org/storage/img/thumb/1389952697.png", text = "Story 11")
        ),
        posts = listOf(
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg",
            "https://1.bp.blogspot.com/_tQWYAIIQ7CY/SYv4vZrmCwI/AAAAAAAAAzY/GVKdGvhMmPI/w1200-h630-p-k-no-nu/178.jpg"
        )
    )
    val size = 3
    val context = LocalContext.current

    Column {
        ProfileHeader(
            backClick = { showToast(context, "Back Button") },
            notificationClick = { showToast(context, "Notification Button") },
            optionClick = { showToast(context, "Options Button") },
            username = user.username
        )
        LazyVerticalGrid(columns = GridCells.Fixed(size)) {

            item(span = {
                GridItemSpan(size)
            }) {
                ProfileInformation(
                    posts = user.posts.size,
                    followers = user.followers,
                    followings = user.followings,
                    imageUrl = user.profileImageUrl
                )
            }
            item(span = {
                GridItemSpan(size)
            }) {
                ProfileDescription(
                    name = user.name,
                    description = user.description,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 4.dp,
                        bottom = 4.dp
                    )
                )
            }
            item(span = {
                GridItemSpan(size)
            }) {
                ProfileAction(
                    followClick = { showToast(context, "Follow Button") },
                    messageClick = { showToast(context, "MessageButton") },
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
            item(span = {
                GridItemSpan(size)
            }) {
                ProfileStoryHighlight(
                    stories = user.stories,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 4.dp,
                        bottom = 4.dp
                    )
                )
            }
            items(user.posts) {
                ProfilePostImage(imageUrl = it, modifier = Modifier.padding(1.dp))
            }
        }
    }
}

private fun showToast(contex: Context, clickedItem: String) {
    Toast.makeText(contex, "Clicked on $clickedItem", Toast.LENGTH_SHORT).show()
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}