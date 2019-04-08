package com.test.filtertest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
//import com.test.filtertest.constant.dataJson
import com.test.filtertest.vo.MallVo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson = Gson()
//        val mallData = gson.fromJson(dataJson, MallVo::class.java)

    }
}
