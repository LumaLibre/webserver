package net.lumamc.web.news

object NewsPostManager {

    val NEWS_POSTS: MutableMap<String, NewsPost> = mutableMapOf()


    fun addNewsPost(newsPost: NewsPost) {
        NEWS_POSTS[generateId()] = newsPost
    }

    fun addNewsPost(id: String, newsPost: NewsPost) {
        NEWS_POSTS[id] = newsPost
    }

    fun removeNewsPost(id: String) {
        NEWS_POSTS.remove(id)
    }

    fun getNewsPost(id: String): NewsPost? {
        return NEWS_POSTS[id]
    }


    private fun generateId(maxLength: Int = 7): String {
        val chars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..maxLength).map { chars.random() }.joinToString("")
    }
}