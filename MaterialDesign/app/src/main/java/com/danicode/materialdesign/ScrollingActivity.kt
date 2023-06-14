package com.danicode.materialdesign

import android.graphics.Color
import android.os.Bundle
// import com.google.android.material.appbar.CollapsingToolbarLayout
// import com.google.android.material.floatingactionbutton.FloatingActionButton
// import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.URLUtil
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.danicode.materialdesign.databinding.ActivityScrollingBinding
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.snackbar.Snackbar

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Botón flotante
        /**
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
        // sI BottomAppBar ESTÁ EN EL CENTRO, colocarlo al final

        if (findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER) {
        findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode =
        BottomAppBar.FAB_ALIGNMENT_MODE_END
        } else {
        findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode =
        BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
        }
        }
         */

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Accediendo usando biding
        binding.fab.setOnClickListener {
            // sI BottomAppBar ESTÁ EN EL CENTRO, colocarlo al final
            if (binding.bottomAppBar.fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER) {
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            } else {
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
        }

        // Snackbar => Mensajes
        binding.bottomAppBar.setNavigationOnClickListener {
            Snackbar.make(binding.root, R.string.message_action_success, Snackbar.LENGTH_SHORT)
                .setAnchorView(binding.bottomAppBar) // Colocarlo arriba del bottomAppBar
                .show()
        }

        // Eventos click (btnSkip)
        // btnSkip!! => se coloca !! porque en los otros layouts (contenet_scrolling de 1240dp y 936dp) no existe ese botón
        binding.content.btnSkip!!.setOnClickListener {
            binding.content.cvAd!!.visibility = View.GONE
        }

        // SnackBar completo => Toast
        binding.content.btnBuy!!.setOnClickListener {
            Snackbar.make(it, R.string.card_buying, Snackbar.LENGTH_LONG)
                .setAnchorView(binding.fab)
                .setAction(R.string.card_to_go) {
                    Toast.makeText(this, R.string.card_historial, Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        // Usando librería GLIDE
        loadImage()

        // Habilitar password
        binding.content.cbEnablePass!!.setOnClickListener {
            binding.content.tilPassword!!.isEnabled = !binding.content.tilPassword!!.isEnabled
        }

        // Cargar imagen de internet por url
        binding.content.etUrl!!.onFocusChangeListener =
            View.OnFocusChangeListener { _, hasFocus ->
                // Validar url
                var errorString: String? = null
                val url = binding.content.etUrl!!.text.toString()
                if (!hasFocus) {
                    if (url.isEmpty()) {
                        errorString = getString(R.string.card_required)
                    } else if (URLUtil.isValidUrl(url)) {
                        loadImage(url)
                    } else {
                        errorString = getString(R.string.card_invalid_url)
                    }
                }
                binding.content.tilUrl!!.error = errorString
            }

        // CheckBox
        binding.content.toggleButton!!.addOnButtonCheckedListener { _, checkedId, _ ->
            binding.content.root.setBackgroundColor(
                when (checkedId) {
                    R.id.btnRed -> Color.RED
                    R.id.btnBlue -> Color.BLUE
                    R.id.btnGreen -> Color.GREEN
                    else -> Color.GRAY
                }
            )
        }
    }

    private fun loadImage(url: String = "https://www.residentevil.com/3/assets/images/character_img01.jpg") {
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(binding.content.imgCover!!)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}