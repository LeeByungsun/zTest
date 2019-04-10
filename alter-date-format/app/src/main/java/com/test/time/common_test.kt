package com.test.time

internal object common_test {

    @JvmStatic
    fun main(args: Array<String>) {
        val time = TimeConvert("PM 01:00:00", 10)
        val time1 = TimeConvert("PM 11:59:59", 1)
        val time2 = TimeConvert("AM 12:10:00", 40)
        val time3 = TimeConvert("AM 05:24:03", 102392)
        println()
        if (time.getTime() == "13:00:10") {
            println("testOK")
        } else  println(message = "test error")

        if (time1.getTime() == "00:00:00") {
            println("testOK")
        } else println("test error")

        if (time2.getTime() == "00:10:40") {
            println("testOK")
        }else println("test error")

        if (time3.getTime() == "09:50:35") {
            println("testOK")
        }else println("test error")


    }

}