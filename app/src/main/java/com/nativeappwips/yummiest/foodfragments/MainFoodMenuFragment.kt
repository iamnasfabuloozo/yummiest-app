package com.nativeappwips.yummiest.foodfragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nativeappwips.yummiest.FoodItem
import com.nativeappwips.yummiest.R
import com.nativeappwips.yummiest.mainfragments.FoodMenuFragment

class MainFoodMenuFragment: Fragment(R.layout.fragment_food_grid) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvFood)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)

        val items = listOf(
                FoodItem(R.drawable.coffee2, "Coffee", "Wendy's Burger", "4.8", "₱ 100"),
                FoodItem(R.drawable.pastries, "Pastries", "Veggie Burger", "5.0", "₱ 100"),
                FoodItem(R.drawable.burgerandfries, "Burger", "Best Burger", "4.0", "₱ 100"),
                FoodItem(R.drawable.pasta, "Pasta", "Veggie Burger", "3.8", "₱ 100"),
        )

        val mainFoodMenuAdapter = MainFoodMenuAdapter(items)
        recyclerView.adapter = mainFoodMenuAdapter

        mainFoodMenuAdapter.setOnItemClickListener { position ->
            Log.d("JONAS", "Item clicked at position: $position")
            // Handle the item click here, e.g., navigate to a detail page
            (parentFragment as? FoodMenuFragment)?.showFoodMenuList()
        }
    }
}