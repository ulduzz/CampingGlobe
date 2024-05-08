package com.ulduzaghayeva.campingglobe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.ulduzaghayeva.campingglobe.databinding.ActivityMainBinding
import com.ulduzaghayeva.campingglobe.fragment.CardDetailFragment
import com.ulduzaghayeva.campingglobe.fragment.FavouritesFragment
import com.ulduzaghayeva.campingglobe.fragment.HomeFragment
import com.ulduzaghayeva.campingglobe.fragment.MyCampsFragment
import com.ulduzaghayeva.campingglobe.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())





        binding.bottomNavigationView.setOnItemSelectedListener{

            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.saved -> replaceFragment(FavouritesFragment())
                R.id.mycamps -> replaceFragment(MyCampsFragment())
                R.id.profile -> replaceFragment(ProfileFragment())

                else ->{


                }


            }
            true

        }






    }
    private fun replaceFragment (fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }







}