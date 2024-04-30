package com.danicode.stores

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.danicode.stores.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Video 17
class MainActivity : AppCompatActivity(), IOnClickListener {
    private lateinit var mBinding: ActivityMainBinding

    // Para el adaptador
    private lateinit var mAdapter: StoreAdapter
    private lateinit var mGridLayot: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnSave.setOnClickListener {
            val storeEntity = StoreEntity(name = mBinding.etName.text.toString().trim())
            // Agregar a la BD (segundo plano para que app no se congele)
            Thread {
                StoreApplication.database.storeDao().addStore(storeEntity)
            }.start()
            // Agregar a la vista
            mAdapter.add(storeEntity)
        }

        setupRecyclerView()
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