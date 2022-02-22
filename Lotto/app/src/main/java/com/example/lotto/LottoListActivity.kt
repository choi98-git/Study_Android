package com.example.lotto

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LottoListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lotto_list_activity)

        val pref = getSharedPreferences("numbers", Context.MODE_PRIVATE)

        val numbers = LottoNumber.getLottoNumbersFromPreference(pref)

        val layoutManager = LinearLayoutManager(this)

        val adapter = LottoNumAdapter(numbers)

        val recyclerView = findViewById<RecyclerView>(R.id.lotto_number_list)
        recyclerView.setHasFixedSize(false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

    }
}