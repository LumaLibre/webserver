package net.lumamc.web

import io.javalin.Javalin
import io.javalin.http.staticfiles.Location
import net.lumamc.web.configuration.ConfigManager
import net.lumamc.web.news.NewsPostManager

class Server {

    private lateinit var internalServer: Javalin

    fun initServer() {
        val cfg = ConfigManager.config
        internalServer = Javalin.create { javalin ->
            javalin.staticFiles.add(cfg.staticFilesDirectory, Location.EXTERNAL)
        }
            .get("/api/news/{id}") { ctx ->
                val id = ctx.pathParam("id")
                val newsPost = NewsPostManager.getNewsPost(id)
                if (newsPost != null) {
                    ctx.result(newsPost.toJson())
                } else {
                    ctx.status(404)
                }
            }
            .start(cfg.port)
    }
}