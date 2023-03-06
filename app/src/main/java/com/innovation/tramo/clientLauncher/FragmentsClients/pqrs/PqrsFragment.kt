package com.innovation.tramo.clientLauncher.FragmentsClients.pqrs

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.innovation.tramo.R

class PqrsFragment : Fragment() {

    companion object {
        fun newInstance() = PqrsFragment()
    }

    private lateinit var viewModel: PqrsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pqrs, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PqrsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}