package com.example.lotto

import android.content.SharedPreferences

data class LottoNumber(var idx:Int, var lottoNumber: String) {
    companion object {
        // 명언을 저장하고 수정하는 함수
        fun saveToPreference(pref: SharedPreferences, idx: Int, lottoNumber : String)
                : LottoNumber {
            val editor = pref.edit()

            editor.putString("$idx.text", lottoNumber)


            editor.apply()

            return LottoNumber(idx, lottoNumber)
        }

        fun getLottoNumbersFromPreference(pref: SharedPreferences): MutableList<LottoNumber>{
            val numbers = mutableListOf<LottoNumber>()

            for (i in 0 until 20) {
                val numberText = pref.getString("$i.text","")!!

                if (numberText.isNotBlank()){
                    numbers.add(LottoNumber(i,numberText))
                }
            }

            return numbers
        }
    }
}
