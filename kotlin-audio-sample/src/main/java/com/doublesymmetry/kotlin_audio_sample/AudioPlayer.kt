package com.doublesymmetry.kotlin_audio_sample

import android.content.Context
import androidx.media3.exoplayer.source.MediaSource
import com.doublesymmetry.kotlinaudio.models.AudioItem
import com.doublesymmetry.kotlinaudio.models.BufferConfig
import com.doublesymmetry.kotlinaudio.models.CacheConfig
import com.doublesymmetry.kotlinaudio.models.PlayerConfig
import com.doublesymmetry.kotlinaudio.players.BaseAudioPlayer
import com.doublesymmetry.kotlinaudio.players.QueuedAudioPlayer

class AudioPlayer(
    context: Context,
    playerConfig: PlayerConfig = com.doublesymmetry.kotlinaudio.models.PlayerConfig(),
    bufferConfig: BufferConfig? = null,
    cacheConfig: CacheConfig? = null
) : QueuedAudioPlayer(context, playerConfig, bufferConfig, cacheConfig) {
    override fun getMediaSourceFromAudioItem(audioItem: AudioItem): MediaSource {
        TODO("Not yet implemented")
    }
}