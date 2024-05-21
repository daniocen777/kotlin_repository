package com.danicode.stores2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.danicode.stores2.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), IOnClickListener {
    private lateinit var mBinding: ActivityMainBinding

    // Para el adaptador
    private lateinit var mAdapter: StoreAdapter
    private lateinit var mGridLayot: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // Fragmento
        mBinding.fabStore.setOnClickListener { launchEditFragment() }

        setupRecyclerView()
    }

    // Lanzar el fragmento
    private fun launchEditFragment() {
        val fragment = EditStoreFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        // containerMain => ID del ConstraintLayout
        fragmentTransaction.add(R.id.containerMain, fragment)
        fragmentTransaction.commit()

        fragmentTransaction.addToBackStack(null) // poder volver al activity_main
        // Ocultar el FloatingActionButton
        mBinding.fabStore.hide()
    }

    private fun setupRecyclerView() {
        mAdapter = StoreAdapter(mutableListOf(), this)
        mGridLayot = GridLayoutManager(this, 2)
        getStores() // Pintar las tiendas guardadas

        mBinding.rvStores.apply {
            setHasFixedSize(true) // tiene tamaño fijo
            layoutManager = mGridLayot
            adapter = mAdapter
        }
    }

    private fun getStores() {
        CoroutineScope(Dispatchers.IO).launch {
            val stores = StoreApplication.database.storeDao().getAllStores()
            runOnUiThread {
                mAdapter.setStores(stores)
            }
        }
    }

    // Interfaz IOnClickListener
    override fun onClick(storeEntity: StoreEntity) {
        TODO("Not yet implemented")
    }

    override fun onFavoriteStore(storeEntity: StoreEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            storeEntity.isFavorite = !storeEntity.isFavorite
            StoreApplication.database.storeDao().updateStore(storeEntity)
            runOnUiThread {
                mAdapter.update(storeEntity)
            }
        }

    }

    override fun onDeleteStore(storeEntity: StoreEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            StoreApplication.database.storeDao().deleteStore(storeEntity)
            runOnUiThread {
                mAdapter.delete(storeEntity)
            }
        }
    }
}