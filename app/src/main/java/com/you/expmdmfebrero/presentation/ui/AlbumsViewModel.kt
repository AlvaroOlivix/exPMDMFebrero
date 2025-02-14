package com.you.expmdmfebrero.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.you.expmdmfebrero.domain.album.Album
import com.you.expmdmfebrero.domain.album.GetAlbumsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class AlbumsViewModel(private val getAlbumsUseCase: GetAlbumsUseCase) : ViewModel() {

    private val _uiState = MutableLiveData(UiState())
    val uiState: LiveData<UiState> = _uiState

    fun viewListAlbums() {
        _uiState.value = UiState(loading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val albumsE = getAlbumsUseCase.invoke()
            _uiState.postValue(UiState(albums = albumsE))
        }
    }


    data class UiState(
        var albums: List<Album> = emptyList(),
        var loading: Boolean = false,
        var error: Error? = null
    )
}