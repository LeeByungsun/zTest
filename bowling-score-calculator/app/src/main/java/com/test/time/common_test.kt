package com.test.time

internal object common_test {

    @JvmStatic
    fun main(args: Array<String>) {
        val firstScore = arrayListOf<String>("A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A")
        val secondScore = arrayListOf<String>("8", "2", "A", "9", "0", "0", "5", "1", "9", "A")
        val thirdScore = arrayListOf<String>("8", "5", "A", "9", "0", "0", "5", "1", "9", "A")
        var calScore1 = CalScore(firstScore)
        var calScore2 = CalScore(secondScore)
        var calScore3 = CalScore(thirdScore)
    }
}