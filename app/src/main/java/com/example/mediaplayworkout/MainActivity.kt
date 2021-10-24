package com.example.mediaplayworkout

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    var mp: MediaPlayer? = null
    var raw = 0
    lateinit var rcvHome: RecyclerView
    lateinit var homeAdapter: HomeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcvHome = findViewById(R.id.rcvHome)
        homeAdapter = HomeAdapter(this, fetchData())
        rcvHome.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        rcvHome.adapter = homeAdapter

    }

    fun playSong(songName: String) {
        when (songName) {
            "Sorry" -> {
                raw = R.raw.sorry
            }
            "Dark Horse" -> {
                raw = R.raw.dark_horse
            }
            "Lazy Song" -> {
                raw = R.raw.lazy_song
            }
        }
        if (mp == null) {
            mp = MediaPlayer.create(this, raw)
            mp!!.start()
        } else {
            mp!!.start()
        }
    }

    fun pauseSong() {
        if (mp != null) {
            mp!!.pause()
        }
    }

    fun stopSong() {
        if (mp != null) {
            mp!!.stop()
            mp!!.release()
            mp = null
        }
    }

    fun isPlaying(): Boolean? {
        var playing: Boolean? = null
        if (mp != null) {
            playing = mp!!.isPlaying
        }
        return playing
    }

    override fun onPause() {
        super.onPause()
        if (mp != null) {
            mp!!.pause()
        }
    }

    override fun onStop() {
        super.onStop()
        if (mp != null) {
            mp!!.pause()
        }
    }

    override fun onResume() {
        super.onResume()
        if(mp!=null){
            mp!!.start()
        }
    }

    private fun fetchData(): ArrayList<SongModel> {
        return arrayListOf(
            SongModel("Justin Bieber", "Purpose", "Sorry"),
            SongModel("Katy Perry", "PRISM", "Dark Horse"),
            SongModel("Bruno Mars", "Doo-Wops & Hooligans", "Lazy Song"),
            SongModel("Justin Bieber", "Purpose", "Sorry"),
            SongModel("Katy Perry", "PRISM", "Dark Horse"),
            SongModel("Bruno Mars", "Doo-Wops & Hooligans", "Lazy Song"),
            SongModel("Justin Bieber", "Purpose", "Sorry"),
            SongModel("Katy Perry", "PRISM", "Dark Horse"),
            SongModel("Bruno Mars", "Doo-Wops & Hooligans", "Lazy Song"),
            SongModel("Justin Bieber", "Purpose", "Sorry"),
            SongModel("Katy Perry", "PRISM", "Dark Horse"),
            SongModel("Bruno Mars", "Doo-Wops & Hooligans", "Lazy Song"),
            SongModel("Justin Bieber", "Purpose", "Sorry"),
            SongModel("Katy Perry", "PRISM", "Dark Horse"),
            SongModel("Bruno Mars", "Doo-Wops & Hooligans", "Lazy Song"),
            SongModel("Justin Bieber", "Purpose", "Sorry"),
            SongModel("Katy Perry", "PRISM", "Dark Horse"),
            SongModel("Bruno Mars", "Doo-Wops & Hooligans", "Lazy Song"),
            SongModel("Justin Bieber", "Purpose", "Sorry"),
            SongModel("Katy Perry", "PRISM", "Dark Horse"),
            SongModel("Bruno Mars", "Doo-Wops & Hooligans", "Lazy Song"),
            SongModel("Justin Bieber", "Purpose", "Sorry"),
            SongModel("Katy Perry", "PRISM", "Dark Horse"),
            SongModel("Bruno Mars", "Doo-Wops & Hooligans", "Lazy Song"),
            SongModel("Justin Bieber", "Purpose", "Sorry"),
            SongModel("Katy Perry", "PRISM", "Dark Horse"),
            SongModel("Bruno Mars", "Doo-Wops & Hooligans", "Lazy Song"),
            SongModel("Justin Bieber", "Purpose", "Sorry"),
            SongModel("Katy Perry", "PRISM", "Dark Horse"),
            SongModel("Bruno Mars", "Doo-Wops & Hooligans", "Lazy Song"),
            SongModel("Justin Bieber", "Purpose", "Sorry"),
            SongModel("Katy Perry", "PRISM", "Dark Horse"),
            SongModel("Bruno Mars", "Doo-Wops & Hooligans", "Lazy Song"),
            SongModel("Justin Bieber", "Purpose", "Sorry"),
            SongModel("Katy Perry", "PRISM", "Dark Horse"),
            SongModel("Bruno Mars", "Doo-Wops & Hooligans", "Lazy Song")
        )
    }
}