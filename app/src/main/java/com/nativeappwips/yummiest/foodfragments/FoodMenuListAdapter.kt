package com.nativeappwips.yummiest.foodfragments

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nativeappwips.yummiest.FoodItem
import com.nativeappwips.yummiest.OnFoodItemViewListener
import com.nativeappwips.yummiest.OnItemAddToCartListener
import com.nativeappwips.yummiest.R
import com.nativeappwips.yummiest.utils.loadImage

class FoodMenuListAdapter(private val items: List<FoodItem>, val res: Int) : RecyclerView.Adapter<FoodMenuListAdapter.ViewHolder>() {

    private var onFoodItemViewListener: OnFoodItemViewListener? = null
    private var onItemAddToCartListener: OnItemAddToCartListener? = null


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivFood: ImageView = itemView.findViewById(R.id.ivFood)
        val titleText: TextView = itemView.findViewById(R.id.tvFoodName)
        val ratingText: TextView = itemView.findViewById(R.id.tvRating)
        val imageViewAddToCart: ImageView = itemView.findViewById(R.id.imageViewAddToCart)
        val frameLayoutAddToCart: FrameLayout = itemView.findViewById(R.id.frameLayoutAddToCart)

        init {
            itemView.setOnClickListener {
                onFoodItemViewListener?.onFoodItemView(adapterPosition)
            }

            frameLayoutAddToCart.setOnClickListener {
                Log.d("JONAS", "Item added to cart via frameLayoutAddToCart")
                onItemAddToCartListener?.onItemAddToCart(adapterPosition, items[adapterPosition])
            }

            imageViewAddToCart.setOnClickListener {
                Log.d("JONAS", "Item added to cart via imageViewAddToCart")
                onItemAddToCartListener?.onItemAddToCart(adapterPosition, items[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(res, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        if (item.imageResId == null) {
            Log.d("JONAS", "Image resource ID is null for item at position $position, using placeholder.")
            holder.ivFood.scaleType = ImageView.ScaleType.CENTER_CROP
        }
        loadImage(holder.itemView.context,
                "",
                item.imageResId,
                holder.ivFood,
                R.drawable.placeholder_image,
                R.drawable.placeholder_err_image,
                circleCrop = false)

        holder.titleText.text = item.title
        holder.ratingText.text = "⭐ ${item.rating}"
//        holder.btnOrders.visibility = View.GONE // Hide the button by default
    }

    override fun getItemCount(): Int = items.size

    fun setOnItemClickListener(clickListener: OnFoodItemViewListener) {
        onFoodItemViewListener = clickListener
    }

    fun setOnItemAddToCartListener(listener: OnItemAddToCartListener) {
        onItemAddToCartListener = listener
    }
}