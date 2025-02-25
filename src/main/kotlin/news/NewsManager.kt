package net.lumamc.web.news

import net.lumamc.web.configuration.ConfigManager
import net.lumamc.web.configuration.NewsConfig
import net.lumamc.web.configuration.sector.NewsArticle

object NewsManager {

    private val newsConfig: NewsConfig = ConfigManager.newsConfig

    fun getNewsArticle(title: String): NewsArticle? {
        return newsConfig.news[title]
    }

    fun getNewsPost(title: String): NewsPost? {
        return newsConfig.news[title]?.let { NewsPost.fromNewsArticle(it) }
    }

    fun getNewsArticles(): Map<String, NewsArticle> {
        return newsConfig.news
    }

    fun getNewsPosts(): Map<String, NewsPost> {
        return newsConfig.news.mapValues { NewsPost.fromNewsArticle(it.value) }
    }

    // Adding news articles programmatically

    fun addNewsArticle(title: String, newsArticle: NewsArticle) {
        newsConfig.news[title] = newsArticle
        newsConfig.save()
    }

    fun removeNewsArticle(title: String) {
        newsConfig.news.remove(title)
        newsConfig.save()
    }
}