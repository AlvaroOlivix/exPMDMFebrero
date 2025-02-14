package com.you.expmdmfebrero.domain.album

import org.koin.core.annotation.Single

@Single
class GetAlbumsUseCase(private val albumRepository: AlbumRepository) {

    operator fun invoke(): List<Album> {
        return albumRepository.getAlbums()
    }
}