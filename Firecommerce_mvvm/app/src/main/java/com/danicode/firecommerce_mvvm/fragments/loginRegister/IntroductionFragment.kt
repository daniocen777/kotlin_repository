package com.danicode.firecommerce_mvvm.fragments.loginRegister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.danicode.firecommerce_mvvm.databinding.FragmentIntroductionBinding

class IntroductionFragment : Fragment() {

    private var _binding: FragmentIntroductionBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIntroductionBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        findNavController().navigate(IntroductionFragmentDirections.actionIntroductionFragmentToAccountOptionsFragment())
    }
}