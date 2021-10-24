package com.example.mediaplayworkout

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter(val context: Context, val songList: ArrayList<SongModel>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    // Holds the views for adding it to image and text
    class HomeViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val txtArtistName = v.findViewById<TextView>(R.id.txtArtist)
        val txtAlbum = v.findViewById<TextView>(R.id.txtAlbum)
        val txtSongName = v.findViewById<TextView>(R.id.txtSongName)
        val imgPlay = v.findViewById<ImageView>(R.id.imgPlay)
        val imgPause = v.findViewById<ImageView>(R.id.imgPause)
        val imgStop = v.findViewById<ImageView>(R.id.imgStop)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.lis_item_home, parent, false)

        return HomeViewHolder(v)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.txtSongName.text = songList[position].songName
        holder.txtArtistName.text = songList[position].artist
        holder.txtAlbum.text = songList[position].album
        holder.imgPause.visibility = View.GONE
        holder.imgStop.visibility = View.GONE
        holder.imgPlay.visibility = View.VISIBLE


        holder.imgPause.setOnClickListener {
            (context as MainActivity).pauseSong()
            if((context as MainActivity).isPlaying()!=null && (context as MainActivity).isPlaying() == true){
                holder.imgPause.visibility = View.VISIBLE
                holder.imgStop.visibility = View.VISIBLE
                holder.imgPlay.visibility = View.GONE
            }else{
                holder.imgPause.visibility = View.GONE
                holder.imgStop.visibility = View.GONE
                holder.imgPlay.visibility = View.VISIBLE
            }
        }
        holder.imgStop.setOnClickListener {
            (context as MainActivity).stopSong()
            holder.imgPause.visibility = View.GONE
            holder.imgStop.visibility = View.GONE
            holder.imgPlay.visibility = View.VISIBLE
        }
        holder.imgPlay.setOnClickListener {
            (context as MainActivity).playSong(songList[position].songName)
            Log.d("mp",(context as MainActivity).isPlaying().toString())
            if((context as MainActivity).isPlaying()!=null && (context as MainActivity).isPlaying() == true){
                holder.imgPause.visibility = View.VISIBLE
                holder.imgStop.visibility = View.VISIBLE
                holder.imgPlay.visibility = View.GONE
            }else{
                holder.imgPause.visibility = View.GONE
                holder.imgStop.visibility = View.GONE
                holder.imgPlay.visibility = View.VISIBLE
            }
        }

    }

    override fun getItemCount(): Int {
        return songList.size
    }

}