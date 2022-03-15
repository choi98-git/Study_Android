package com.example.listviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var drinkList = arrayListOf<Drink>(
        Drink(R.drawable.coke, "콜라", "1500원"),
        Drink(R.drawable.cider, "사이다", "1200원"),
        Drink(R.drawable.sprite, "스프라이트", "1500원"),
        Drink(R.drawable.fanta, "환타", "1500원"),
        Drink(R.drawable.sparkling, "스파클링", "1000원")
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listview = findViewById<ListView>(R.id.listview)

        val drinkAdapter = ListAdapter(this, drinkList)
        listview.adapter = drinkAdapter

        listview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "${drinkList[position].name}는 ${drinkList[position].price}입니다.",
            Toast.LENGTH_SHORT).show()
        }
    }
}