package com.you.expmdmfebrero.presentation.adapter.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.you.expmdmfebrero.R
import com.you.expmdmfebrero.domain.album.Album

class AlbumAdapter:
    ListAdapter<Album, AlbumViewHolder>(AlbumDiffUtil()) {

    private var onClick: (String) -> Unit = {}
    private var onFavoriteClick: (Album) -> Unit = {}

    fun setOnClickListener(onClickListener: (String) -> Unit) {
        onClick = onClickListener
    }
    fun setOnFavoriteClickListener(onFavoriteClickListener: (Album) -> Unit) {
        onFavoriteClick = onFavoriteClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_item_album, parent, false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = getItem(position)
            holder.bind(album, onClick, onFavoriteClick)
    }


    override fun getItemCount(): Int = 10

}