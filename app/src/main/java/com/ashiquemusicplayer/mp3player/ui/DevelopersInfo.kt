package com.ashiquemusicplayer.mp3player.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ashiquemusicplayer.mp3player.R
import kotlinx.android.synthetic.main.activity_developers_info.*

class DevelopersInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developers_info)

        // Loading the url of the information's of the developer
        webView.loadUrl("http://ashiquebava.online/portfolio.html")
    }
}