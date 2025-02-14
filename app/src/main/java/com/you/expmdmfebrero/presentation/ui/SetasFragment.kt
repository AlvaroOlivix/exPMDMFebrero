package com.you.expmdmfebrero.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.you.expmdmfebrero.databinding.FragmentSetasBinding
import com.you.expmdmfebrero.presentation.adapter.setas.SetasAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SetasFragment : Fragment() {
    private var _binding: FragmentSetasBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SetasViewModel by viewModel()
    private val setasAdapter = SetasAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSetasBinding.inflate(inflater, container, false)
        setUpView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewListSetas()
        setUpObserver()
    }

    private fun setUpObserver() {
        val observerS = Observer<SetasViewModel.UiState>() { uiState ->
            uiState.setas?.let {
                setasAdapter.submitList(it)
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
        viewModel.uiState.observe(viewLifecycleOwner, observerS)
    }

    private fun setUpView() {
        binding.apply {
            recyclerContainerSetas.layoutManager =
                LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL, false
                )
            recyclerContainerSetas.adapter = setasAdapter

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}