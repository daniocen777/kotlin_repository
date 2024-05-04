package com.danicode.horocopoapp.ui.palmistry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.danicode.horocopoapp.databinding.FragmentPalmistryBinding
import dagger.hilt.android.AndroidEntryPoint

// Colocar anotacion "@AndroidEntryPoint" para que pueda ser inyectada o inyecte a otra clase
@AndroidEntryPoint
class PalmistryFragment : Fragment() {
    private var _binding: FragmentPalmistryBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }
}