package com.test.loginTest

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import com.test.loginTest.ApplicationTest.Companion.pref
import com.test.loginTest.databinding.ActivityMainBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import jp.wasabeef.glide.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    var agree = false
    private val loginid = "꽃피는시절"
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.main = this
        agree = pref.getBoolean("agree", false)
        println(agree)
        initUI()


    }

    @SuppressLint("CheckResult")
    private fun initUI() {
        toolbar_title.text = String.format(getString(R.string.toolbartitle), loginid)
        et1.hint = String.format(getString(R.string.id), loginid)
        termTv.text = Html.fromHtml(getString(R.string.termTv))

        termCheck.setOnClickListener {
            setAgree()
            this.changeTermCheck()
        }
        Glide.with(this).load(R.drawable.original)
            .apply(bitmapTransform(CropCircleTransformation()))
            .into(imageview)

        RxView.clicks(login).throttleFirst(5, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                textview1.text = getString(R.string.logining)
                textview2.visibility = View.GONE
                login.apply {
                    isClickable = false
                    isEnabled = false
                }
                Observable.timer(5, TimeUnit.SECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        textview1.text = getString(R.string.loginsuccess)
                        textview2.visibility = View.GONE
                        login.apply {
                            isEnabled = true
                            isClickable = true
                        }
                        pref.edit().apply {
                            putBoolean("agree", agree)
                            apply()
                        }
                    }
            }
        RxTextView.textChanges(et1).filter { it.isNotEmpty() }
            .subscribe {
                login.isEnabled = it.length > 5
            }
    }

    fun setAgree() {
        agree = !agree
    }

    fun changeTermCheck() = if (agree) {
        termCheck.setBackgroundResource(R.drawable.checked_normal)
        autologin.visibility = View.VISIBLE
        login.isClickable = true
        term.visibility = View.GONE
    } else {
        termCheck.setBackgroundResource(R.drawable.unchecked_normal)
        autologin.visibility = View.INVISIBLE
        login.isClickable = false
        term.visibility = View.VISIBLE
    }
}
