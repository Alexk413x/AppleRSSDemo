package com.alexk413x.mobile.applerssdemo.viewHolders

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.alexk413x.mobile.applerssdemo.R
import com.alexk413x.mobile.applerssdemo.models.Album
import com.bumptech.glide.Glide

class AlbumViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.album_row, parent, false)) {

    private var albumArtView: ImageView? = null
    private var albumTitleView: TextView? = null
    private var albumArtistView: TextView? = null

    init {
        albumArtView = itemView.findViewById(R.id.album_artwork_view)
        albumTitleView = itemView.findViewById(R.id.album_title_view)
        albumArtistView = itemView.findViewById(R.id.album_artist_view)
    }

    fun bind(album: Album, clickListener: (Album) -> Unit){
        Glide.with(itemView.context)
            .load(album.artworkUrl)
            .placeholder(R.drawable.marbles)
            .centerInside()
            .into(albumArtView!!)

        albumTitleView?.text = album.name
        albumArtistView?.text = album.artistName

        itemView.setOnClickListener { clickListener(album) }
    }
}