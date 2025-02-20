package net.lumamc.web.configuration

import eu.okaeri.configs.OkaeriConfig
import eu.okaeri.configs.serdes.standard.StandardSerdes
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer
import java.io.File
import java.nio.file.Path
import eu.okaeri.configs.ConfigManager as OkaeriConfigManager


object ConfigManager {

    val config: Config

    init {
        this.config = OkaeriConfigManager.create(Config::class.java) { it: OkaeriConfig ->
            it.withConfigurer(YamlSnakeYamlConfigurer(), StandardSerdes())
            it.withRemoveOrphans(false)
            println(this.getJarFileDirectoryPath().resolve("config.yml"))
            it.withBindFile(this.getJarFileDirectoryPath().resolve("config.yml"))
            it.saveDefaults()
            it.load(true)
        }
    }

    fun getJarFileDirectoryPath(): Path {
        val path: String = this.javaClass.protectionDomain.codeSource.location.path
        val jarFile = File(path)
        return jarFile.parentFile.toPath()
    }
}