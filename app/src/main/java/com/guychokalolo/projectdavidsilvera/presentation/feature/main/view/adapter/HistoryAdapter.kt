package com.guychokalolo.projectdavidsilvera.presentation.feature.main.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.guychokalolo.projectdavidsilvera.R
import com.guychokalolo.projectdavidsilvera.domain.entity.ProductEntity
import com.guychokalolo.projectdavidsilvera.presentation.feature.main.view.OnProductClickListener

class HistoryAdapter(
    private val onProductClickListener: OnProductClickListener
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private val products: MutableList<ProductEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(products[position],onProductClickListener)
    }

    override fun getItemCount(): Int = products.size

    fun setData(list: List<ProductEntity>) {
        this.products.clear()
        this.products.addAll(list)
        notifyDataSetChanged()
    }

    class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val productTitle : TextView = view.findViewById(R.id.product_name)
        private val productImage : ImageView = view.findViewById(R.id.product_image)

        fun bind(product: ProductEntity, onProductClickListener: OnProductClickListener) {
            productTitle.text = product.genericName
            Glide.with(itemView.context).load(product.imageUrl).into(productImage)
            onProductClickListener.onProductClicked(product)
        }
    }
}