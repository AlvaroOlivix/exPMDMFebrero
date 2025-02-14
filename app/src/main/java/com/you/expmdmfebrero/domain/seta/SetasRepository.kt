package com.you.expmdmfebrero.domain.seta

interface SetasRepository {
    fun getSetas(): List<Setas>
    fun getSetaById():Setas
}