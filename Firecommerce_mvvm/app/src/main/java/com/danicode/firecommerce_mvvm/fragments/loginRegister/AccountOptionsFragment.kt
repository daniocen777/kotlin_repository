package com.danicode.firecommerce_mvvm.fragments.loginRegister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.danicode.firecommerce_mvvm.databinding.FragmentAccountOptionsBinding


class AccountOptionsFragment : Fragment() {

    private var _binding: FragmentAccountOptionsBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAccountOptionsBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        mBinding.apply {
            optionsBtnRegister.setOnClickListener {
                findNavController().navigate(AccountOptionsFragmentDirections.actionAccountOptionsFragmentToRegisterFragment())
            }

            optionsBtnLogin.setOnClickListener {
                findNavController().navigate(AccountOptionsFragmentDirections.actionAccountOptionsFragmentToLoginFragment())
            }
        }
    }
}