package net.lumamc.web


fun main() {
    println("Hello World!")


    val server = Server()
    server.initServer()
    println("http://localhost:7070/api/news/test")
}