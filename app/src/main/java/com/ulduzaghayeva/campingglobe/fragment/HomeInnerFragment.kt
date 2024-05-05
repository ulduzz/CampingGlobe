package com.ulduzaghayeva.campingglobe.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ulduzaghayeva.campingglobe.adapter.CampAdapter
import com.ulduzaghayeva.campingglobe.R
import com.ulduzaghayeva.campingglobe.databinding.FragmentHomeInnerBinding
import com.ulduzaghayeva.campingglobe.modelshomedata.Camp
import com.ulduzaghayeva.campingglobe.fragment.CardDetailFragment

class HomeInnerFragment : Fragment(), CampAdapter.OnItemClickListener {

    private lateinit var GridView: RecyclerView
    private lateinit var binding: FragmentHomeInnerBinding

    private val camps = listOf(
        Camp("Quba Camp", 75, "AZN", "2-3 Noyabr", R.drawable.img_3),
        Camp("Samur Camp", 80, "AZN", "2–3 November", R.drawable.img_16) ,
        Camp("Qabala Camp", 40, "AZN", "2-3 Noyabr", R.drawable.img_18),
        Camp("İsmayilli Camp", 55, "AZN", "2–3 November", R.drawable.img_19) ,
        Camp("Qaranohur Camp", 75, "AZN", "2-3 Noyabr", R.drawable.img_3),
        Camp("GoyGol Camp", 80, "AZN", "2–3 November", R.drawable.img_16) ,
        Camp("Lahij Camp", 40, "AZN", "2-3 Noyabr", R.drawable.img_18),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeInnerBinding.inflate(inflater, container, false)
        val view = binding.root

        GridView = binding.recyclerView
        GridView.layoutManager = GridLayoutManager(context, 2)

        val adapter = CampAdapter(camps, this)
        GridView.adapter = adapter

        return view
    }

    override fun onItemClick(camp: Camp) {
        val fragment = CardDetailFragment()
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.rec, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
