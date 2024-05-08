package com.danicode.horocopoapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.danicode.horocopoapp.databinding.ActivityHoroscopeDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

// Colocar anotacion "@AndroidEntryPoint" para que pueda ser inyectada o inyecte a otra clase
@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityHoroscopeDetailBinding

    // Acceder al viewModel
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    // Recuperar signo sodiacal que se mando desde HoroscopeFragment
    private val args: HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        horoscopeDetailViewModel.getHoroscope(args.zodiacSign.name)
        initUI()
    }

    private fun initUI() {
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when (it) {
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun loadingState() {
        mBinding.pbDescription.isVisible = true
    }

    private fun errorState() {
        mBinding.pbDescription.isVisible = false
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        mBinding.pbDescription.isVisible = false
        mBinding.tvZodiac.text = state.sign
        mBinding.tvDescription.text = state.data
    }
}