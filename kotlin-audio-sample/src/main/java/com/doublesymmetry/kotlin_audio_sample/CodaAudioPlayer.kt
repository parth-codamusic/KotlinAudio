package com.doublesymmetry.kotlin_audio_sample

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.media3.common.util.Util
import androidx.media3.datasource.DataSpec
import androidx.media3.datasource.DefaultDataSourceFactory
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.datasource.RawResourceDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.MediaSource
import com.doublesymmetry.kotlinaudio.models.*
import com.doublesymmetry.kotlinaudio.players.QueuedAudioPlayer
import com.doublesymmetry.kotlinaudio.utils.isUriLocal

class CodaAudioPlayer(
     val context: Context,
    playerConfig: PlayerConfig = PlayerConfig(),
    bufferConfig: BufferConfig? = null,
    cacheConfig: CacheConfig? = null
) : QueuedAudioPlayer(context, playerConfig, bufferConfig, cacheConfig) {


    override fun load(item: AudioItem) {
        Log.e("TAG", "LOAD ")
        super.load(item)
    }


    override fun prepareExoPlayer(exoPlayer: ExoPlayer) {
        Log.e("TAG", "PREPARE")
        exoplayerPrepare(Uri.parse("https://codamusic.me/api/v7/tempGetStream/?trackId=332758&expireToken=&uid=189359"))
    }

    override fun load(item: AudioItem, playWhenReady: Boolean) {
        Log.e("TAG", "LOAD @")
        super.load(item, playWhenReady)
    }
}