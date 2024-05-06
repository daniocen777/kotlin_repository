package com.danicode.horocopoapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.danicode.horocopoapp.databinding.ItemHoroscopeBinding
import com.danicode.horocopoapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val mBinding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val context = mBinding.tvTitle.context
        mBinding.ivHoroscope.setImageResource(horoscopeInfo.img)
        mBinding.tvTitle.text = context.getString(horoscopeInfo.name)

        mBinding.clItemHoroscope.setOnClickListener {
            // onItemSelected(horoscopeInfo)
            startRotationAnimation(
                mBinding.ivHoroscope,
                customLambda = { onItemSelected(horoscopeInfo) })
        }
    }

    // Animacion
    private fun startRotationAnimation(view: View, customLambda: () -> Unit) {
        view.animate().apply {
            duration = 500 // milisegundos
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { customLambda() } // se ejecuta luego de terminar animacion
            start()
        }
    }
}