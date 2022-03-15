package com.example.listviewtest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter (val context: Context, val drinkList: ArrayList<Drink>) : BaseAdapter(){
    override fun getCount(): Int {
        return drinkList.size
    }

    override fun getItem(position: Int): Any {
        return  drinkList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.listview_item,null)

        val drinkImg = view.findViewById<ImageView>(R.id.image)
        val drinkName = view.findViewById<TextView>(R.id.name)
        val drinkPrice = view.findViewById<TextView>(R.id.price)

        val drink = drinkList[position]

        drinkImg.setImageResource(drink.image)
        drinkName.text = drink.name
        drinkPrice.text = drink.price

        return view
    }
}