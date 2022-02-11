package com.example.lifecycletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Activity가 처음 생성돠는 시점에 호출
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("mytag", "onCreate")
    }

    //  Activity가 화면에 표시되기 시작하는 시점에 호출
    override fun onStart() {
        super.onStart()
        Log.d("mytag", "onStart")
    }

    // Activity가 전면에 표시되어 활성화되고 사용자와 상호 작용이 가능해지는 시점에 호출
    override fun onResume() {
        super.onResume()
        Log.d("mytag","onResume")
    }

    // Activity가 화면에서 사라지고 사용자와의 상호 작용이 불가능해지는 비활성화 시점에 호출
    override fun onPause() {
        super.onPause()
        Log.d("mytag", "onPause")
    }

    // Activity가 화면에서 완전히 사라진 시점( ex) 백그라운드상태 )
    override fun onStop() {
        super.onStop()
        Log.d("mytag", "onStop")
    }
    // Activity가 종료되는 시점(앱을 완전히 꺼버린 시점)
    override fun onDestroy() {
        super.onDestroy()
        Log.d("mytag", "onDestroy")
    }

    // Activity가 재시작되는 시점에 호출 -> 이후 바로 onStart 호출()
    override fun onRestart() {
        super.onRestart()
        Log.d("mytag", "onRestart")
    }

}