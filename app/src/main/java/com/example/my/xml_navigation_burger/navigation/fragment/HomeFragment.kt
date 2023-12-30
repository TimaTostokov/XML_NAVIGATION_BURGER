package com.example.my.xml_navigation_burger.navigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.my.xml_navigation_burger.R
import com.example.my.xml_navigation_burger.bottom.fragment.CartFragment
import com.example.my.xml_navigation_burger.bottom.fragment.CategoryFragment
import com.example.my.xml_navigation_burger.bottom.fragment.HistoryFragment
import com.example.my.xml_navigation_burger.bottom.fragment.NotificationFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_category -> {
                    replaceFragment(CategoryFragment())
                    activity?.title = "Category"
                }

                R.id.bottom_history -> {
                    replaceFragment(HistoryFragment())
                    activity?.title = "History"
                }

                R.id.bottom_notification -> {
                    replaceFragment(NotificationFragment())
                    activity?.title = "Notification"
                }

                R.id.bottom_cart -> {
                    replaceFragment(CartFragment())
                    activity?.title = "Cart"
                }
            }
            true
        }

        replaceFragment(CategoryFragment())
        activity?.title = "Category"
        bottomNavigationView.selectedItemId = R.id.bottom_category

        val addFab = view.findViewById<FloatingActionButton>(R.id.addFabBtn)
        addFab.setOnClickListener {
            Toast.makeText(context, "Add Clicked", Toast.LENGTH_LONG).show()
        }
        return view
    }

    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.bottomFragment, fragment)
            .commit()
    }

}