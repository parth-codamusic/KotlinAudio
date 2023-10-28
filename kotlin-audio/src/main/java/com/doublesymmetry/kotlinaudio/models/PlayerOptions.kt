package com.doublesymmetry.kotlinaudio.models

interface PlayerOptions {
    var alwaysPauseOnInterruption: Boolean
}
data class DefaultPlayerOptions(
    override var alwaysPauseOnInterruption: Boolean = false,
) : PlayerOptions
