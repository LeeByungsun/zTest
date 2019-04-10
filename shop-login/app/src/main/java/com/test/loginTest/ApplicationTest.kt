package com.test.loginTest

import android.app.Application
import android.content.SharedPreferences
import com.test.loginTest.constant.PREF

class ApplicationTest : Application() {

    companion object {
        lateinit var pref: SharedPreferences
    }

    override fun onCreate() {
        super.onCreate()
        pref = this.getSharedPreferences(PREF, 0)
    }
}