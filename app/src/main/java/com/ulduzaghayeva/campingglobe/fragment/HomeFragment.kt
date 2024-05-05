package com.ulduzaghayeva.campingglobe.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.ulduzaghayeva.campingglobe.R
import com.ulduzaghayeva.campingglobe.adapter.HomePagerAdapter


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { val view = inflater.inflate(R.layout.fragment_home, container, false)

        val viewPager: ViewPager = view.findViewById(R.id.ViewPager)
        val tabLayout: TabLayout = view.findViewById(R.id.HomeTabLayout)

        val color = ContextCompat.getColor(requireContext(), R.color.blue)

        val adapter = HomePagerAdapter(childFragmentManager)
        adapter.addFragment(HomeInnerFragment(), "Camp")
        adapter.addFragment(DailyToursFragment(), "Daily Tours")


        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.setSelectedTabIndicatorColor(color)

        return view
    }
}