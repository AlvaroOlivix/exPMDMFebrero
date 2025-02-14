package com.you.expmdmfebrero.presentation.adapter.album

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.you.expmdmfebrero.R
import com.you.expmdmfebrero.databinding.ViewItemAlbumBinding
import com.you.expmdmfebrero.domain.album.Album

class AlbumViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ViewItemAlbumBinding.bind(view)
    fun bind(album: Album, onClick: (String) -> Unit, onFavoriteClick: (Album) -> Unit) {
        binding.apply {
            nombre.text = album.nombre
            descripcion.text = album.descripcion
            fecha.text = album.fecha
            binding.favBoton.setImageResource(
                if (album.favorito) R.drawable.ic_colored else R.drawable.ic_uncolored
            )
            view.setOnClickListener {
                onClick.invoke(album.id)
            }
            binding.favBoton.setOnClickListener {
                onFavoriteClick.invoke(album)
            }

        }
    }
}