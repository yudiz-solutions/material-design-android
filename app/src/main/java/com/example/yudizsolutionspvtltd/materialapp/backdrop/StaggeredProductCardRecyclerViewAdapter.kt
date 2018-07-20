package com.example.yudizsolutionspvtltd.materialapp.backdrop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.NetworkImageView
import com.example.yudizsolutionspvtltd.materialapp.R
import com.example.yudizsolutionspvtltd.materialapp.bottomAppBar.ImageReq
import com.example.yudizsolutionspvtltd.materialapp.bottomAppBar.TravelEntry

class StaggeredProductCardRecyclerViewAdapter(private val productList: List<TravelEntry>?) : RecyclerView.Adapter<StaggeredProductCardViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return position % 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaggeredProductCardViewHolder {
        var layoutId = R.layout.shr_staggered_product_card_first
        if (viewType == 1) {
            layoutId = R.layout.shr_staggered_product_card_second
        } else if (viewType == 2) {
            layoutId = R.layout.shr_staggered_product_card_third
        }
        val layoutView = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return StaggeredProductCardViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: StaggeredProductCardViewHolder, position: Int) {
        if (productList != null && position < productList.size) {
            val product = productList[position]
            holder.productTitle.text = product.title
            holder.productPrice.text = product.price
            ImageReq.setImageFromUrl(holder.productImage, product.url)
        }
    }

    override fun getItemCount(): Int {
        return productList?.size ?: 0
    }
}

class StaggeredProductCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var productImage: NetworkImageView = itemView.findViewById(R.id.product_image)
    var productTitle: TextView = itemView.findViewById(R.id.product_title)
    var productPrice: TextView = itemView.findViewById(R.id.product_price)
}

