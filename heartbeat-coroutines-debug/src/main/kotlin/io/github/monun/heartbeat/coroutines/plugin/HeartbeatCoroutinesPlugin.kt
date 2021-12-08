package io.github.monun.heartbeat.coroutines.plugin

import io.github.monun.heartbeat.coroutines.HeartbeatScope
import io.github.monun.heartbeat.coroutines.delayTick
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.bukkit.plugin.java.JavaPlugin

class HeartbeatCoroutinesPlugin : JavaPlugin() {
    override fun onEnable() {
        HeartbeatScope().launch {
            while (true) {
                delayTick(20)
                println(server.isPrimaryThread)
            }
        }
    }
}