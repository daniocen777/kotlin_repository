package com.danicode.instagramcompose.profile

data class User(
    val username: String,
    val profileImageUrl: String,
    val followers: Int,
    val followings: Int,
    val name: String,
    val description: String,
    val stories: List<Story>,
    val posts: List<String>
)

data class Story(val image: String, val text: String)
