package com.danicode.firecommerce_mvvm.fragments.loginRegister

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.danicode.firecommerce_mvvm.data.model.User
import com.danicode.firecommerce_mvvm.databinding.FragmentRegisterBinding
import com.danicode.firecommerce_mvvm.utils.RegisterValidation
import com.danicode.firecommerce_mvvm.utils.Resource
import com.danicode.firecommerce_mvvm.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val mBinding get() = _binding!!

    private val viewModel by viewModels<RegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {
        mBinding.apply {
            registerBtnRegister.setOnClickListener {
                val user = User(
                    firstname = registerEtFirstName.text.toString().trim(),
                    lastname = registerEtLastName.text.toString().trim(),
                    email = registerEtEmail.text.toString().trim()
                )
                val password = registerEtPassword.text.toString()

                viewModel.createAccountWithEmailAndPassword(user, password)
            }
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.register.collect {
                    when (it) {
                        is Resource.Loading -> {
                            mBinding.registerBtnRegister.startAnimation()
                        }
                        is Resource.Success -> {
                            Log.i("RegisterFragment Success", it.data.toString())
                            mBinding.registerBtnRegister.revertAnimation()
                        }
                        is Resource.Error -> {
                            Log.i("RegisterFragment Error", it.message.toString())
                            mBinding.registerBtnRegister.revertAnimation()
                        }
                        else -> Unit
                    }
                }
            }
        }
        // Validaciones
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.validation.collect { validation ->
                    if (validation.email is RegisterValidation.Failed) {
                        withContext(Dispatchers.Main) {
                            mBinding.registerEtEmail.apply {
                                requestFocus()
                                error = validation.email.message
                            }
                        }
                    }
                    if (validation.password is RegisterValidation.Failed) {
                        withContext(Dispatchers.Main) {
                            mBinding.registerEtPassword.apply {
                                requestFocus()
                                error = validation.password.message
                            }
                        }
                    }
                }
            }
        }
    }
}