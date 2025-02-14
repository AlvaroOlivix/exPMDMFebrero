package com.you.expmdmfebrero.presentation.adapter.setas

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.you.expmdmfebrero.databinding.ViewSetaItemBinding
import com.you.expmdmfebrero.domain.seta.Setas

class SetasViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ViewSetaItemBinding.bind(view)
    fun bind(setas: Setas) {
        binding.apply {
            nombre.text = setas.nombre
            image
        }
    }
}