package com.you.expmdmfebrero.presentation.adapter.setas

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.you.expmdmfebrero.domain.album.Album
import com.you.expmdmfebrero.domain.seta.Setas

class SetasDiffUtil : DiffUtil.ItemCallback<Setas>() {
        override fun areItemsTheSame(oldItem: Setas, newItem: Setas): Boolean {
            return oldItem.nombre == newItem.nombre
        }
        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Setas, newItem: Setas): Boolean {
            return oldItem == newItem
        }
    }