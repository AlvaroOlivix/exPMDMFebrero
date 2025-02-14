package com.you.expmdmfebrero.presentation.adapter.album

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.you.expmdmfebrero.domain.album.Album

class AlbumDiffUtil : DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }

}