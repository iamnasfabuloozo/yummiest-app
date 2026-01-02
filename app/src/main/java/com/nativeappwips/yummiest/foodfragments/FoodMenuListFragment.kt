package com.nativeappwips.yummiest.foodfragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nativeappwips.yummiest.FoodItem
import com.nativeappwips.yummiest.R

class FoodMenuListFragment : Fragment(R.layout.fragment_food_menu) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackPressed()

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvFood)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

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

        val foodMenuAdapter = FoodMenuListAdapter(items)
        recyclerView.adapter = foodMenuAdapter

        foodMenuAdapter.setOnItemClickListener { position ->
            Log.d("JONAS", "Item clicked at position: $position")
            // Handle the item click here, e.g., navigate to a detail page
//            (parentFragment as? FoodMenuFragment)?.showFoodMenuList()
        }

        foodMenuAdapter.setOnItemAddToCartListener { position, item ->
            Log.d("JONAS", "Item added to cart: ${item.title} at position: $position")
            // Handle the add to cart action here
            // For example, update the cart in the ViewModel or navigate to a cart page
        }
    }

    private fun onBackPressed() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            // Handle back press logic here
            // For example, navigate back to the previous fragment or activity
            parentFragmentManager.popBackStack()
        }
    }
}

