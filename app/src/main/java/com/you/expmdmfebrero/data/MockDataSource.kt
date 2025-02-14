package com.you.expmdmfebrero.data

import com.you.expmdmfebrero.domain.album.Album

class MockDataSource {


    private fun getAlbums(): List<Album> {
        return listOf(
            Album("1", "Album1", "10-10-08", "Descripcion", "url", false),
            Album("2", "Album2", "10-10-08", "Descripcion", "url", false),
            Album("3", "Album3", "10-10-08", "Descripcion", "url", false),
            Album("4", "Album1", "10-10-08", "Descripcion", "url", false),
            Album("5", "Album1", "10-10-08", "Descripcion", "url", false),
            Album("6", "Album1", "10-10-08", "Descripcion", "url", false),
            Album("7", "Album1", "10-10-08", "Descripcion", "url", false),
            Album("8", "Album1", "10-10-08", "Descripcion", "url", false),
            Album("9", "Album1", "10-10-08", "Descripcion", "url", false),
            Album("10", "Album1", "10-10-08", "Descripcion", "url", false)
        )
    }
}