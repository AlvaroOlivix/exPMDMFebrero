package com.you.expmdmfebrero.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.you.expmdmfebrero.domain.album.Album
import com.you.expmdmfebrero.domain.seta.GetSetasUseCase
import com.you.expmdmfebrero.domain.seta.Setas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SetasViewModel(private val getSetasUseCase: GetSetasUseCase) : ViewModel() {


    private val _uiState = MutableLiveData(UiState())
    val uiState: LiveData<UiState> = _uiState

    fun viewListSetas() {
        _uiState.value = UiState(loading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val setasS = getSetasUseCase.invoke()
            _uiState.postValue(UiState(setas = setasS))
        }
    }


    data class UiState(
        var setas: List<Setas> = emptyList(),
        var loading: Boolean = false,
        var error: Error? = null
    )
}