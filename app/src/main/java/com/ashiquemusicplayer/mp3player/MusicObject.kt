package com.ashiquemusicplayer.mp3player

import android.media.MediaPlayer
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

object MusicObject {

    private lateinit var mediaPlayer: MediaPlayer
    private val executor: ExecutorService = Executors.newSingleThreadExecutor()
    private var flag = 0

    // Function to play music
    fun playMusic(mp: MediaPlayer) {
        if (flag > 0) {
            pauseMusic()
        }
        flag++
        mediaPlayer = mp
        executor.execute {
            mediaPlayer.start()
        }
    }

    // Function to play currently playing music again
    fun playMusicAgain() {
        executor.execute {
            mp.start()
        }
    }

    // Function to pause music
    fun pauseMusic() {
        mediaPlayer.pause()
    }

    // Function to stop music
    fun stopMusic() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
    }
}