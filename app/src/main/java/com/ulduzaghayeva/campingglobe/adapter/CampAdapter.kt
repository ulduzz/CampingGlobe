package com.ulduzaghayeva.campingglobe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.ulduzaghayeva.campingglobe.R
import com.ulduzaghayeva.campingglobe.fragment.CardDetailFragment
import com.ulduzaghayeva.campingglobe.modelshomedata.Camp


class CampAdapter(

    private val camps: List<Camp>,

    ) : RecyclerView.Adapter<CampAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.camp_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val camp = camps[position]
        holder.CampName.text = camp.name
        holder.TextPrice.text = camp.price.toString()
        holder.imageView.setImageResource(camp.imageView)
        holder.TextValuyuta.text = camp.currency
        holder.texttarih.text = camp.date


    }

    override fun getItemCount(): Int {
        return camps.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val CampName: TextView = itemView.findViewById(R.id.Text5)
        val TextPrice: TextView = itemView.findViewById(R.id.TextPrice)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val TextValuyuta: TextView = itemView.findViewById(R.id.TextValuyuta)
        val texttarih: TextView = itemView.findViewById(R.id.texttarih)
    }
}