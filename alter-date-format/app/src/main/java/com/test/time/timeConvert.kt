package com.test.time


class TimeConvert() {
    private var orgHour = 0
    private var orgMinute = 0
    private var orgSecond = 0
    private var orgTime = 0
    private var ampm: Int = 0
    private var nextSecond = 0
    private var newTime = 0
    private lateinit var changeTime: String

    constructor(inputTime: String, second: Int) : this() {
        println(inputTime)
        nextSecond = second
        setTime(inputTime)
        changeTime()
    }

    private fun setTime(inputTime: String) {

        val s = inputTime.split(" ").toTypedArray()
        val time = s[1].split(":").toTypedArray()

        s.let {
            when (s[0]) {
                "PM" -> ampm = 12 * 3600
                "AM" -> ampm = 0
            }
        }

        time.let {
            orgHour = time[0].toInt() * 3600
            orgMinute = time[1].toInt() * 60
            orgSecond = time[2].toInt()
            orgTime = orgHour + orgMinute + orgSecond + ampm
            println(orgTime)
        }
    }

    private fun changeTime() {
        newTime = orgTime + nextSecond
        if (newTime in 86400..171999) {
            newTime -= 86400
        } else if (newTime in 172000..259200) {
            newTime -= 86400
        }
        var min = newTime / 60
        var hour = min / 60
        val second = newTime % 60
        min %= 60
        if (ampm == 0 && newTime > 43200) {
            hour = 0
        }
        changeTime = String.format("%02d:%02d:%02d", hour, min, second)
        println(changeTime)
    }

    fun getTime(): String {
        return changeTime
    }

}