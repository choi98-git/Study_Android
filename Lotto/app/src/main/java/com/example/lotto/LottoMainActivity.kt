package com.example.lotto

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
private var lottoText = ""
private lateinit var lottoNumber: TextView

class LottoMainActivity : AppCompatActivity() {

    private lateinit var LottoNumbers: MutableList<LottoNumber>
    private lateinit var pref: SharedPreferences
    private var idx: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lotto_main_activity)
        pref = getSharedPreferences("numbers", Context.MODE_PRIVATE)


        lottoNumber = findViewById(R.id.lotto_number)
        val makeLottoNumberBtn = findViewById<Button>(R.id.make_number_btn)
        val saveLottoNumberBtn = findViewById<Button>(R.id.save_number_btn)
        val checkSavedNumberBtn = findViewById<Button>(R.id.check_saved_number_btn)
        val checkResultBtn = findViewById<Button>(R.id.check_result_number)


        createRandomNumber()
        makeLottoNumberBtn.setOnClickListener { createRandomNumber() }

        saveLottoNumberBtn.setOnClickListener {
            val text = lottoNumber.text.toString()
            LottoNumber.saveToPreference(pref,idx, text)
            idx++
            val editor =pref.edit()
            editor.apply()
            Toast.makeText(this, "번호가 저장되었습니다.", Toast.LENGTH_SHORT).show()
        }
        checkSavedNumberBtn.setOnClickListener {
            val intent = Intent(this, LottoListActivity::class.java)
            startActivity(intent)
        }

        checkResultBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dhlottery.co.kr/gameResult.do?method=byWin"))
            startActivity(intent)
        }

    }

    private fun createRandomNumber(){
        val numberSet = mutableListOf<Int>()

        while (numberSet.size < 6 ){
            val randomNumber = Random.nextInt(1,46)

            if (numberSet.contains(randomNumber)){
                continue
            }
            numberSet.add(randomNumber)
        }

        numberSet.sort()
        lottoNumber.text = numberSet.toString()
    }

}