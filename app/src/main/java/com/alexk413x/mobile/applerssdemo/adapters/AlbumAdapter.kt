package com.alexk413x.mobile.applerssdemo.adapters

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.alexk413x.mobile.applerssdemo.models.Album
import com.alexk413x.mobile.applerssdemo.viewHolders.AlbumViewHolder

class AlbumAdapter(private var albums: ArrayList<Album>, private val clickListener: (Album) -> Unit): RecyclerView.Adapter<AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AlbumViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = albums.size

    override fun onBindViewHolder(viewHolder: AlbumViewHolder, position: Int) {
        val album: Album = albums[position]
        viewHolder.bind(album, clickListener)
    }

    fun updateAlbums(photos : ArrayList<Album>) {
        DiffUtil.calculateDiff(AlbumDiffCallback(photos, albums), false).dispatchUpdatesTo(this)
        this.albums = photos
    }
}

class AlbumDiffCallback(private val newRows : List<Album>, private val oldRows : List<Album>) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldRow = oldRows[oldItemPosition]
        val newRow = newRows[newItemPosition]
        return oldRow.id == newRow.id
    }

    override fun getOldListSize(): Int = oldRows.size

    override fun getNewListSize(): Int = newRows.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldRow = oldRows[oldItemPosition]
        val newRow = newRows[newItemPosition]
        return oldRow == newRow
    }
}