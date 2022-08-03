package io.github.monun.heartbeat.coroutines.plugin

import io.github.monun.heartbeat.coroutines.HeartbeatScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.bukkit.plugin.java.JavaPlugin

class HeartbeatCoroutinesPlugin : JavaPlugin() {
    override fun onEnable() {
        HeartbeatScope().launch {
            while (true) {
                delay(1L)
                println(server.isPrimaryThread)
            }
        }
    }
}