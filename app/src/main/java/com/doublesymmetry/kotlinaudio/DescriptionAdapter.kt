package com.doublesymmetry.kotlinaudio

import android.app.PendingIntent
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import coil.imageLoader
import coil.request.ImageRequest
import com.doublesymmetry.kotlinaudio.models.AudioItem
import com.google.android.exoplayer2.MediaMetadata
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.PlayerNotificationManager

/**
 * Provides content assets of the media currently playing. If certain data is missing from [AudioItem], data from the media's metadata is used instead.
 */
class DescriptionAdapter(private val context: Context, private val pendingIntent: PendingIntent?): PlayerNotificationManager.MediaDescriptionAdapter {
    override fun getCurrentContentTitle(player: Player): CharSequence {
        val audioItem = player.currentMediaItem?.playbackProperties?.tag as AudioItem?
        return audioItem?.title ?: player.mediaMetadata.displayTitle ?: ""
    }

    override fun createCurrentContentIntent(player: Player): PendingIntent? {
        return pendingIntent
    }

    override fun getCurrentContentText(player: Player): CharSequence? {
        val audioItem = player.currentMediaItem?.playbackProperties?.tag as AudioItem?
        return audioItem?.artist ?: player.mediaMetadata.artist ?: player.mediaMetadata.albumArtist
    }

    override fun getCurrentLargeIcon(
        player: Player,
        callback: PlayerNotificationManager.BitmapCallback,
    ): Bitmap? {
        val audioItem = player.currentMediaItem?.playbackProperties?.tag as AudioItem?
        var artworkBitmap: Bitmap? = null

        val imageLoader = context.imageLoader
        val request = ImageRequest.Builder(context)
            .data(getArtworkSource(audioItem, player.mediaMetadata))
            .target { artworkBitmap = (it as BitmapDrawable).bitmap }
            .build()

        imageLoader.enqueue(request)
        return artworkBitmap
    }

    private fun getArtworkSource(audioItem: AudioItem?, mediaMetadata: MediaMetadata): Any? {
        val data: ByteArray? = mediaMetadata.artworkData

        return when {
            audioItem?.artwork != null -> audioItem.artwork
            mediaMetadata.artworkUri != null -> mediaMetadata.artworkUri
            data != null -> BitmapFactory.decodeByteArray(data, 0, data.size)
            else -> null
        }
    }
}