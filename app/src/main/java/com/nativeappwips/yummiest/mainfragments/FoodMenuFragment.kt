package com.nativeappwips.yummiest.mainfragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.nativeappwips.yummiest.MainActivity
import com.nativeappwips.yummiest.foodfragments.FoodMenuListFragment
import com.nativeappwips.yummiest.foodfragments.MainFoodMenuFragment
import com.nativeappwips.yummiest.R
import com.nativeappwips.yummiest.foodfragments.FoodDetailsFragment

class FoodMenuFragment : Fragment(R.layout.fragment_container) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) { // Only add the fragment if it's the first creation
            childFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, MainFoodMenuFragment())
                    .commit()
        }

    }

    fun showFoodMenuList() {
        Log.d("JONAS", "Showing food menu list")
        childFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FoodMenuListFragment())
                .addToBackStack(null)
                .commit()
    }

    fun showFoodItemDetails() {
        Log.d("JONAS", "Showing food item details")
        childFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FoodDetailsFragment())
                .addToBackStack(null)
                .commit()
    }

    fun setPagerSwipe(enabled: Boolean) {
        (activity as? MainActivity)?.setPagerSwipe(enabled)
    }


//    private fun showFoodMenuFromFoodMenuType(foodType: String) {
//        // This function can be used to refresh or show the food menu if needed
//        Log.d("JONAS", "Showing food menu $foodType")
//        parentFragmentManager.beginTransaction().replace(R.id.fragment_container, FoodMenuFromFoodMenuTypeFragment.newInstance(foodType))
//            .addToBackStack(null)
//            .commit()
//    }

}