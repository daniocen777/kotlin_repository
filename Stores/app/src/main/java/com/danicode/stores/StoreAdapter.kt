package com.danicode.stores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danicode.stores.databinding.ItemStoreBinding

class StoreAdapter(
    private var stores: MutableList<StoreEntity>,
    private var listener: IOnClickListener
) :
    RecyclerView.Adapter<StoreAdapter.StoreViewHolder>() {
    // mContext: m => miembro de la clase
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        mContext = parent.context
        val view =
            LayoutInflater.from(mContext).inflate(R.layout.item_store, parent, false)

        return StoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val store = stores.get(position)
        with(holder) {
            setListener(store)
            binding.tvName.text = store.name
            binding.cbFavorite.isChecked = store.isFavorite
        }
    }

    override fun getItemCount(): Int = stores.size

    fun add(storeEntity: StoreEntity) {
        stores.add(storeEntity)
        notifyDataSetChanged() // refrescar la vista
    }

    fun setStores(stores: MutableList<StoreEntity>) {
        this.stores = stores
        notifyDataSetChanged() // refrescar la vista
    }

    fun update(storeEntity: StoreEntity) {
        val index = stores.indexOf(storeEntity)
        if (index != -1) {
            stores[index] = storeEntity
            notifyItemChanged(index) // solo notificar el item actualizado
        }
    }

    fun delete(storeEntity: StoreEntity) {
        val index = stores.indexOf(storeEntity)
        if (index != -1) {
            stores.removeAt(index)
            notifyItemRemoved(index) // solo notificar el item eliminado
        }
    }

    // ViewHolder
    inner class StoreViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemStoreBinding.bind(view)

        fun setListener(storeEntity: StoreEntity) {
            with(binding.root) {
                setOnClickListener { listener.onClick(storeEntity) }
                // Eliminar tienda
                setOnLongClickListener {
                    listener.onDeleteStore(storeEntity)
                    true
                }
            }
            // Modificar favoritos
            binding.cbFavorite.setOnClickListener { listener.onFavoriteStore(storeEntity) }


        }
    }
}