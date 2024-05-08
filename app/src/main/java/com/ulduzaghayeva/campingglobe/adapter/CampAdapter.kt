package com.ulduzaghayeva.campingglobe.adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ulduzaghayeva.campingglobe.R
import com.ulduzaghayeva.campingglobe.modelshomedata.Camp


class CampAdapter(
    private val camps: List<Camp>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<CampAdapter.ViewHolder>() {


    interface OnItemClickListener {
        fun onItemClick(camp: Camp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.camp_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val camp = camps[position]
        holder.bind(camp, itemClickListener)

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

        fun bind(camp: Camp, clickListener: OnItemClickListener) {
            CampName.text = camp.name
            TextPrice.text = camp.price.toString()
            imageView.setImageResource(camp.imageView)
            TextValuyuta.text = camp.currency
            texttarih.text = camp.date

            itemView.setOnClickListener {
                clickListener.onItemClick(camp)
            }
        }
    }
}
