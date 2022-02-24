package com.example.lotto

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class LottoNumAdapter(private var dataList: List<LottoNumber>) : RecyclerView.Adapter<LottoNumAdapter.LottoNumItemViewHolder>() {
    class LottoNumItemViewHolder(val view: View): RecyclerView.ViewHolder(view){
        lateinit var numbers: LottoNumber
        val savedLottoNumber = view.findViewById<TextView>(R.id.saved_lotto_number)
        val deleteLottoNumber = view.findViewById<ImageButton>(R.id.delete_number_btn)

        init {

            val pref = view.context.getSharedPreferences("numbers", Context.MODE_PRIVATE)
            deleteLottoNumber.setOnClickListener {

                LottoNumber.removeLottoNumbersFromPreference(pref, adapterPosition)
                Toast.makeText(view.context, "삭제되었습니다.", Toast.LENGTH_SHORT).show()

            }
        }

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

//        holder.view.findViewById<Button>(R.id.delete_number_btn).setOnClickListener {
//            notifyDataSetChanged()
//        }

    }

    override fun getItemCount() = dataList.size

    override fun getItemViewType(position: Int) = R.layout.lotto_number_item


}