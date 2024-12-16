package com.example.stateruppage.food.foodManis

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.stateruppage.R
import com.example.stateruppage.data.Product
import com.example.stateruppage.food.foodgurih.DetailFoodGurihActivity

class FoodManisListAdapter(private val context: Context, private val productList: List<Product>) :
    RecyclerView.Adapter<FoodManisListAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val product = productList[position]
        holder.tvBrandName.text = product.history.product_name
        holder.tvBrandOverview.text = product.history.product_desc
        Glide.with(context)
            .load(product.history.product_pic)
            .into(holder.ivLogo)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailFoodGurihActivity::class.java)
            intent.putExtra("PRODUCT_NAME", product.history.product_name)
            intent.putExtra("PRODUCT_DESC", product.history.product_desc)
            intent.putExtra("PRODUCT_PIC", product.history.product_pic)
            intent.putExtra("PRODUCT_CATEGORY", product.history.product_category)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivLogo: ImageView = itemView.findViewById(R.id.iv_logo)
        val tvBrandName: TextView = itemView.findViewById(R.id.tv_brand_name)
        val tvBrandOverview: TextView = itemView.findViewById(R.id.tv_brand_overview)
    }
}