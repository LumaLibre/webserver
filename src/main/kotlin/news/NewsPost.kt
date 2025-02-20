package net.lumamc.web.news

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File
import java.net.URL
import java.time.LocalDateTime

class NewsPost(
    val title: String,
    val thumbnail: URL,
    val author: String,
    val date: LocalDateTime,
    val content: File
) {

    companion object {
        private val gson: Gson = GsonBuilder().setPrettyPrinting().create()
    }

    fun toSimpleObject(): SimpleNewsPost {
        val simple = SimpleNewsPost(
            title,
            thumbnail.toExternalForm(),
            author,
            date.toString(),
            content.readText()
        )
        return simple
    }

    fun toJson(): String {
        return gson.toJson(this.toSimpleObject())
    }


    override fun toString(): String {
        return """
            {
                "title": "$title",
                "thumbnail": "${thumbnail.toExternalForm()}",
                "author": "$author",
                "date": "$date",
                "content": "${content.absolutePath}"
            }
        """.trimIndent()
    }
}