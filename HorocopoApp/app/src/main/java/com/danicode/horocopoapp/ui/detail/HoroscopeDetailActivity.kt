package com.danicode.horocopoapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.navArgs
import com.danicode.horocopoapp.R
import com.danicode.horocopoapp.databinding.ActivityHoroscopeDetailBinding
import com.danicode.horocopoapp.domain.model.HoroscopeModel
import dagger.hilt.android.AndroidEntryPoint

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


    }
}