package com.danicode.horocopoapp.ui.luck

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import com.danicode.horocopoapp.R
import com.danicode.horocopoapp.databinding.FragmentLuckBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random

// Colocar anotacion "@AndroidEntryPoint" para que pueda ser inyectada o inyecte a otra clase
@AndroidEntryPoint
class LuckFragment : Fragment() {
    private var _binding: FragmentLuckBinding? = null
    private val mBinding get() = _binding!!

    // Metodo cuando la vista haya sido creada, enganchar el Flow del viwModel al Fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initListeners()
    }

    private fun initListeners() {
        mBinding.ivRoulette.setOnClickListener {
            spinRoulette() // girar roluta
        }
    }

    // Animacion de giro
    private fun spinRoulette() {
        val random = Random()
        // random.nextInt(limite => 360*4)
        val degrees = random.nextInt(1440) + 360 // al menos 1 vuelta
        // ObjectAnimator.ofFloat(vista, tipo_animacion, desde_en_grados, hasta_en_grados)
        val animator =
            ObjectAnimator.ofFloat(mBinding.ivRoulette, View.ROTATION, 0f, degrees.toFloat())
        animator.duration = 2000 // 2 segundos de animacion
        animator.interpolator = DecelerateInterpolator() // Desacelerar animacion (acabar lento)
        animator.doOnEnd { slideCard() } // cuando termine, ejecutar siguiente animacion
        animator.start()
    }

    // Animacion de deslizar hacia arriba
    private fun slideCard() {
        val slideUpAnimation = AnimationUtils.loadAnimation(
            requireContext(),
            R.anim.slide_up
        ) // animacion hecha en xml

        slideUpAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
                mBinding.ivReverse.isVisible = true
            }

            // Cuando termine la animacion, lanzar otra donde carta crezca
            override fun onAnimationEnd(p0: Animation?) {
                growCard()
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }

        })

        mBinding.ivReverse.startAnimation(slideUpAnimation)
    }

    private fun growCard() {
        val growAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.grow)
        growAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {}

            override fun onAnimationEnd(p0: Animation?) {
                // Mostrar pantalla de suerte
                mBinding.ivReverse.isVisible = false
                showPremonitionView()
            }

            override fun onAnimationRepeat(p0: Animation?) {}

        })

        mBinding.ivReverse.startAnimation(growAnimation)
    }

    private fun showPremonitionView() {
        // Mostrar la nueva vista
        // AlphaAnimation => Opacidad
        val disappearAnimation = AlphaAnimation(1.0f, 0.0f)
        disappearAnimation.duration = 200
        // aparecer la imagen con lentitud
        val appearAnimation = AlphaAnimation(0.0f, 1.0f)
        appearAnimation.duration = 1000

        disappearAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {}

            override fun onAnimationEnd(p0: Animation?) {
                mBinding.clPreview.isVisible = false
                mBinding.clPrediction.isVisible = true
            }

            override fun onAnimationRepeat(p0: Animation?) {}

        })

        mBinding.clPreview.startAnimation(disappearAnimation)
        mBinding.clPrediction.startAnimation(appearAnimation)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLuckBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }


}