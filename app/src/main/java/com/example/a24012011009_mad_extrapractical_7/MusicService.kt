package com.example.a24012011009_mad_extrapractical_7

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MusicService : Service() { // service is parent class

    companion object{
        val SERVICE_KEY = "Service1"
        val SERVICE_DATA = "PlayButton"
    }

    lateinit var mediaPlayer: MediaPlayer // lateinit will initialize late but will not return null.

    override fun onBind(intent: Intent): IBinder { // primary constructor
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (!this::mediaPlayer.isInitialized) {// "::" is used to initialize .is attributes
            mediaPlayer = MediaPlayer.create(this, R.raw.song)
        }
        if (intent!=null){
            val str1 : String?=intent.getStringExtra(SERVICE_KEY)
            if (str1 == SERVICE_DATA){
                if (!mediaPlayer.isPlaying)
                    mediaPlayer.start()
                else
                    mediaPlayer.pause()
            }
        }

        return START_STICKY
    }

    override fun onDestroy() {
        mediaPlayer.stop()
        super.onDestroy()
    }

}