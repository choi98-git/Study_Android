package com.example.recyclerviewtest

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DrinkAdapter (val context: Context, val drinkList: ArrayList<Drink>) :
    RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var drink: Drink

        val drinkImage = view.findViewById<ImageView>(R.id.image)
        val drinkName = view.findViewById<TextView>(R.id.name)
        val drinkPrice = view.findViewById<TextView>(R.id.price)

        fun bind(d: Drink) {
            drink = d

            drinkImage.setImageResource(drink.img)
            drinkName.text = drink.name
            drinkPrice.text = drink.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DrinkAdapter.ViewHolder, position: Int) {
        holder.bind(drinkList[position])
    }

    override fun getItemCount() = drinkList.size


}