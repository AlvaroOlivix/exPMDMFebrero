package com.you.expmdmfebrero.domain.album

interface AlbumRepository {
    fun getAlbums(): List<Album>
    fun getAlbumById(albumId: String): Album?

}