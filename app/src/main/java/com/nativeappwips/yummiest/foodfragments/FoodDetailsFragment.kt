package com.nativeappwips.yummiest.foodfragments

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nativeappwips.yummiest.FoodItem
import com.nativeappwips.yummiest.R
import com.nativeappwips.yummiest.mainfragments.FoodMenuFragment

class FoodDetailsFragment: Fragment(R.layout.fragment_food_details) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackPressed()
        (parentFragment as? FoodMenuFragment)?.setPagerSwipe(false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvAddOns)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val items = listOf(
                FoodItem(R.drawable.ic_burger, "Burger", "Wendy's Burger", "4.8", "₱ 100"),
                FoodItem(R.drawable.ic_burger, "Burger", "Veggie Burger", "5.0", "₱ 100"),
                FoodItem(R.drawable.ic_burger, "Burger", "Best Burger", "4.0", "₱ 100"),
                FoodItem(null, "Burger", "Veggie Burger", "3.8", "₱ 100"),
                FoodItem(R.drawable.ic_burger, "Burger", "Veggie Burger", "3.8", "₱ 100"),
                FoodItem(R.drawable.ic_burger, "Burger", "Veggie Burger", "3.8", "₱ 100"),
                FoodItem(R.drawable.ic_burger, "Burger", "Veggie Burger", "3.8", "₱ 100"),
                FoodItem(R.drawable.ic_burger, "Burger", "Veggie Burger", "3.8", "₱ 100"),
                FoodItem(R.drawable.ic_burger, "Burger", "Veggie Burger", "3.8", "₱ 100")
        )

        val foodMenuAdapter = FoodMenuListAdapter(items, R.layout.item_food_grid_2)
        recyclerView.adapter = foodMenuAdapter

    }

    private fun onBackPressed() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            // Handle back press logic here
            // For example, navigate back to the previous fragment or activity
            parentFragmentManager.popBackStack()
        }
    }
}