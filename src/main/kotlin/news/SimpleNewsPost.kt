package net.lumamc.web.news

data class SimpleNewsPost(
    val title: String,
    val thumbnail: String,
    val author: String,
    val date: String,
    val content: String
)