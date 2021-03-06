package com.ashiquemusicplayer.mp3player.notification

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.ashiquemusicplayer.mp3player.R
import com.ashiquemusicplayer.mp3player.ui.MainActivity
import com.ashiquemusicplayer.mp3player.ui.MusicPlayingActivity

class NotificationService: Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val notificationIntent = Intent(this, MusicPlayingActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)

        val songName = intent?.getStringExtra("songName")
        val notification = NotificationCompat.Builder(this,
        "musicChannel",)
            .setContentTitle(
                songName
                    ?.replace("%20", " ")
                    ?.replace("%5B", " ")
                    ?.replace("%5D", " ")
                    ?.replace("%2C", " ")
                    ?.replace("%26", " ")
                    ?.replace("%5B", " ")
                    ?.replace("%5D", " "))
            .setSmallIcon(R.drawable.defaultsonglogo)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}