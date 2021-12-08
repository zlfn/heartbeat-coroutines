package io.github.monun.heartbeat.coroutines

import kotlinx.coroutines.delay

suspend fun delayTick(ticks: Int) {
    delay(ticks * 50L - 1L)
}