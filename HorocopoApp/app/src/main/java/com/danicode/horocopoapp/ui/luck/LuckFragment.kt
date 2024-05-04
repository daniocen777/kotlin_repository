package com.danicode.horocopoapp.ui.luck

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danicode.horocopoapp.R
import com.danicode.horocopoapp.databinding.FragmentLuckBinding
import dagger.hilt.android.AndroidEntryPoint

// Colocar anotacion "@AndroidEntryPoint" para que pueda ser inyectada o inyecte a otra clase
@AndroidEntryPoint
class LuckFragment : Fragment() {
    private var _binding: FragmentLuckBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLuckBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }


}