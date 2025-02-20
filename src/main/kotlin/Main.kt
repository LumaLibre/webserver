package net.lumamc.web

import net.lumamc.web.news.NewsPost
import net.lumamc.web.news.NewsPostManager
import java.io.File
import java.net.URI
import java.time.LocalDateTime


fun main() {
    println("Hello World!")

    val file = File(ClassLoader.getSystemResource("content.md").toURI())

    val newsPost = NewsPost(
        "Hello World!",
        URI.create("https://www.example.com/image.png").toURL(),
        "LumaMC",
        LocalDateTime.now(),
        file
    )

    NewsPostManager.addNewsPost("test", newsPost)

    val server = Server()
    server.initServer()
    println("http://localhost:7070/api/news/test")
}