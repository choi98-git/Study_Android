package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var drinkAdapter: DrinkAdapter

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

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        drinkAdapter = DrinkAdapter(this, drinkList)
        recyclerView.adapter = drinkAdapter

        val layoutmanager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutmanager
        recyclerView.setHasFixedSize(true)

    }
}