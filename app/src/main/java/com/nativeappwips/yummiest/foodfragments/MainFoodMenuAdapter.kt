package com.nativeappwips.yummiest.foodfragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nativeappwips.yummiest.FoodItem
import com.nativeappwips.yummiest.OnFoodItemViewListener
import com.nativeappwips.yummiest.R
import com.nativeappwips.yummiest.utils.loadImage


class MainFoodMenuAdapter(private val items: List<FoodItem>) : RecyclerView.Adapter<MainFoodMenuAdapter.ViewHolder>() {

    private var onFoodItemViewListener: OnFoodItemViewListener? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivFood: ImageView = itemView.findViewById(R.id.ivFood)
        val titleText: TextView = itemView.findViewById(R.id.tvFoodName)

        init {
            itemView.setOnClickListener {
                onFoodItemViewListener?.onFoodItemView(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food_category_grid, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        loadImage(holder.itemView.context,
                "",
                item.imageResId,
                holder.ivFood,
                R.drawable.placeholder_image,
                R.drawable.placeholder_err_image,
                circleCrop = false)

        holder.titleText.text = item.title
    }

    override fun getItemCount(): Int = items.size

    fun setOnItemClickListener(clickListener: OnFoodItemViewListener) {
        onFoodItemViewListener = clickListener
    }
}