package net.lumamc.web.configuration

import eu.okaeri.configs.OkaeriConfig
import eu.okaeri.configs.annotation.Comment
import java.nio.file.Path

class Config : OkaeriConfig() {

    @Comment("Port to start Javalin on")
    var port = 7070

    @Comment("Path to the directory containing static files")
    var staticFilesDirectory: String = "~/static"
        get() {
            val value: Path = Path.of(field.replace("~", ConfigManager.getJarFileDirectoryPath().toAbsolutePath().toString()))
            val asFile = value.toFile()
            if (!asFile.exists()) {
                asFile.mkdirs()
            }
            return value.toString()
        }
}