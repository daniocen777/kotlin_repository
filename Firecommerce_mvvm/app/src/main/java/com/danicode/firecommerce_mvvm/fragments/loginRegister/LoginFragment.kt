package com.danicode.firecommerce_mvvm.fragments.loginRegister

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.danicode.firecommerce_mvvm.activities.ShoppingActivity
import com.danicode.firecommerce_mvvm.databinding.FragmentLoginBinding
import com.danicode.firecommerce_mvvm.dialog.setupBottomSheetDialog
import com.danicode.firecommerce_mvvm.utils.Resource
import com.danicode.firecommerce_mvvm.viewmodel.LoginViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val mBinding get() = _binding!!

    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        initUIState()
    }

    private fun initListeners() {
        mBinding.apply {
            loginBtnLogin.setOnClickListener {
                val email = loginEtEmail.text.toString().trim()
                val password = loginEtPassword.text.toString().trim()

                viewModel.login(email, password)
            }
        }

        mBinding.loginTvForgotPassword.setOnClickListener {
            setupBottomSheetDialog { email ->
                viewModel.resetPassword(email)
            }
        }
    }

    private fun initUIState() {
        // Login
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.login.collect {
                    when (it) {
                        is Resource.Loading -> {
                            Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                        }
                        is Resource.Success -> {
                            // Ir a la pantalla de Shoping sin regresar a la pantalla anterior
                            Intent(requireActivity(), ShoppingActivity::class.java).also { intent ->
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                                startActivity(intent)
                            }
                        }
                        is Resource.Error -> {
                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                        }
                        is Resource.Unspecified -> Unit
                    }
                }
            }
        }

        // Reset Password
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.resetPassword.collect {
                    when (it) {
                        is Resource.Loading -> Unit
                        is Resource.Success -> {
                            Snackbar.make(
                                requireView(),
                                "Reset link was send to your email",
                                Snackbar.LENGTH_LONG
                            ).show()
                        }
                        is Resource.Error -> {
                            Snackbar.make(
                                requireView(),
                                "Error: ${it.message}",
                                Snackbar.LENGTH_LONG
                            ).show()
                        }
                        is Resource.Unspecified -> Unit
                    }
                }
            }
        }
    }
}