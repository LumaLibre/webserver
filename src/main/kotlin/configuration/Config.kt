package net.lumamc.web.configuration

import eu.okaeri.configs.OkaeriConfig
import eu.okaeri.configs.annotation.Comment
import net.lumamc.web.Util

class Config : OkaeriConfig() {

    @Comment("Port to start Javalin on")
    var port = 7070

    @Comment("Path to the directory containing static files")
    var staticFilesDirectory: String = "~/static"
        get() {
            val value = Util.getDataFolderPath()
            return field.replaceFirst("~", value.toString())
        }
}