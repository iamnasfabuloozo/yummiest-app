package com.nativeappwips.yummiest

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.nativeappwips.yummiest.mainfragments.FoodMenuFragment
import com.nativeappwips.yummiest.mainfragments.OrderHistoryFragment
import com.nativeappwips.yummiest.mainfragments.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var tabLayout: TabLayout
    private lateinit var toolbar: Toolbar
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageViewCart: ImageView
    private lateinit var viewPager: ViewPager2
    private lateinit var appPagerAdapter: AppPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)

        tabLayout = findViewById(R.id.tabLayout)
        drawerLayout = findViewById(R.id.drawerLayout)
        toolbar = findViewById(R.id.toolbar)
        recyclerView = findViewById(R.id.drawerRecyclerView)
        imageViewCart = findViewById(R.id.imageViewBagCart)
        viewPager = findViewById(R.id.viewPager)

        setSupportActionBar(toolbar)
// Drawer toggle (hamburger menu)
        imageViewCart.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.END)
        }

        setupTabs(tabLayout)


        val fragments = mutableListOf(
                FoodMenuFragment(),
                OrderHistoryFragment(),
                ProfileFragment()
        )

        appPagerAdapter = AppPagerAdapter(this, fragments)

        viewPager.adapter = appPagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Set the custom view for each tab
            val iconRes = when (position) {
                0 -> R.drawable.ic_home
                1 -> R.drawable.ic_search
                2 -> R.drawable.ic_heart
                else -> R.drawable.ic_home // Default icon
            }
            tab.customView = createCustomTab(iconRes, 22) // 28dp icon size
        }.attach()


        // Only add the fragment if this is the first creation
//        if (savedInstanceState == null) {
//            Log.d("JONAS", "default fragment")
//            supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragment_container, FoodMenuFragment())
//                    .commitNow()
//        }
    }

    private fun createCustomTab(iconRes: Int, sizeDp: Int): View {
        val view = LayoutInflater.from(this).inflate(R.layout.custom_tab, null)
        val icon = view.findViewById<ImageView>(R.id.tabIcon)

        val params = icon.layoutParams
        params.width = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, sizeDp.toFloat(), resources.displayMetrics
        ).toInt()
        params.height = params.width
        icon.layoutParams = params

        icon.setImageResource(iconRes)
        return view
    }

    private fun setupTabs(tabLayout: TabLayout) {
        val icons = listOf(
                R.drawable.ic_home,
                R.drawable.ic_search,
                R.drawable.ic_heart,
                R.drawable.ic_user
        )

        // Menu
        //Transactions Lists
        //Orders (Pickup, Delivery, Dine-in) with Notification badges
        icons.forEachIndexed { index, iconRes ->
            val tab = tabLayout.newTab()
            tab.customView = createCustomTab(iconRes, 22) // 28dp icon size
            tabLayout.addTab(tab)
        }
    }

    fun setPagerSwipe(enabled: Boolean) {
        viewPager.isUserInputEnabled = enabled
    }
}
