package com.danicode.stores2

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.danicode.stores2.databinding.FragmentEditStoreBinding
import com.google.android.material.snackbar.Snackbar

class EditStoreFragment : Fragment() {

    private lateinit var mBinding: FragmentEditStoreBinding
    private var mActivity: MainActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentEditStoreBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    // Ciclio de vida, va despues del onCreateView => Aca se manipula los elementos del fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Conseguir la actividad en la cual esta alojada el fragment
        mActivity = activity as? MainActivity
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true) // Retroceder pantalla
        mActivity?.supportActionBar?.title = getString(R.string.edit_store_title_add) // titulo
        setHasOptionsMenu(true) // boton en el appBar (onCreateOptionsMenu)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_save, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    // Captar eventos dentro del menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            // Boton de retorceso
            android.R.id.home -> {
                mActivity?.onBackPressedDispatcher?.onBackPressed()
                true
            }
            // Boton para editar o guardar
            R.id.action_save -> {
                Snackbar.make(
                    mBinding.root,
                    getString(R.string.edit_store_message_save_success),
                    Snackbar.LENGTH_SHORT
                ).show()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }

    }
}