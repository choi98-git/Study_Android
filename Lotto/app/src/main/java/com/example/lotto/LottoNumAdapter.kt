package com.example.lotto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LottoNumAdapter(private var dataList: List<LottoNumber>) : RecyclerView.Adapter<LottoNumAdapter.LottoNumItemViewHolder>() {

    class LottoNumItemViewHolder(val view: View): RecyclerView.ViewHolder(view){
        lateinit var numbers: LottoNumber
        val savedLottoNumber = view.findViewById<TextView>(R.id.saved_lotto_number)

        fun bind(l: LottoNumber){
            savedLottoNumber.text = l.lottoNumber
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LottoNumItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return LottoNumItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: LottoNumItemViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    override fun getItemViewType(position: Int) = R.layout.lotto_number_item


}