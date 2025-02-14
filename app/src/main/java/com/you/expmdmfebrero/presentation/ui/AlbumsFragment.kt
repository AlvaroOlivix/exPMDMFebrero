package com.you.expmdmfebrero.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.you.expmdmfebrero.databinding.FragmentAlbumsBinding
import com.you.expmdmfebrero.presentation.adapter.album.AlbumAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlbumsFragment : Fragment() {

    private var _binding: FragmentAlbumsBinding? = null
    private val binding get() = _binding!!

    private val viewModel:AlbumsViewModel by viewModel()
    private val albumAdapter = AlbumAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlbumsBinding.inflate(inflater, container, false)
        setUpView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       viewModel.viewListAlbums()
        setUpObserver()
    }

    private fun setUpObserver() {
        val observer = Observer<AlbumsViewModel.UiState>() { uiState ->
            uiState.albums?.let {
                albumAdapter.submitList(it)
                Log.d("@dev", "Vista cargada")
            }
            uiState.error?.let {
                //Error en el observer
                Log.d("@dev", "Error en el observer")
            }
            if (uiState.loading) {
                //Cargando la pantalla
                Log.d("@dev", "Cargando datos")
            } else {
                //Cargado finish
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun setUpView() {
        binding.apply {
            recyclerContainerAlbums.layoutManager =
                LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL, false
                )
            recyclerContainerAlbums.adapter = albumAdapter

        }

    }

    private fun navigateToSetas(){
        findNavController().navigate(AlbumFragmentDirectoins().albumListToSetasList())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}