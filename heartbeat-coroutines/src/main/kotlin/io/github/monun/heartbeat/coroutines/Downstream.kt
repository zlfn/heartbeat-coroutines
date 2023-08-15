package io.github.monun.heartbeat.coroutines

import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin


/**
 * Bukkit의 LibraryLoader로 로딩되었을 때 ClassLoader의 플러그인을 불러옵니다.
 */
internal object Downstream {
    fun pullPlugin(): Plugin {
        return try {
            Bukkit.getLogger().info(JavaPlugin.getProvidingPlugin(Downstream::class.java).name)
            JavaPlugin.getProvidingPlugin(Downstream::class.java)
        } catch(e: Exception) {
            error("Failed to load plugin")
        }
    }
}