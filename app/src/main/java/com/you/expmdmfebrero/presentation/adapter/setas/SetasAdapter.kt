package com.you.expmdmfebrero.presentation.adapter.setas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.you.expmdmfebrero.R
import com.you.expmdmfebrero.domain.seta.Setas

class SetasAdapter : ListAdapter<Setas, SetasViewHolder>(SetasDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetasViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_seta_item, parent, false)
        return SetasViewHolder(view)
    }

    override fun onBindViewHolder(holder: SetasViewHolder, position: Int) {
        val setas = getItem(position)
        holder.bind(setas)
    }

    override fun getItemCount(): Int = 10
}
