package com.test.time


class CalScore() {
    constructor(inputScore: MutableList<String>) : this() {
        val scoreList: ArrayList<Score> = initScore(inputScore)
        var totalScore = 0
        loop@ for (i in 0 until scoreList.size - 1) {
            when {
                scoreList[i].s && scoreList[i].getSum() == 10 -> {
                    totalScore += scoreList[i].getSum()
                    totalScore += (if (scoreList[i + 1]?.s) {
                        if (i == scoreList.size - 2) {
                            break@loop
                        } else {
                            scoreList[i + 1]?.getSum() + scoreList[i + 2]?.getSum()
                        }

                    } else scoreList[i + 1]?.first + scoreList[i + 1]?.second)
                }
                else -> when {
                    !scoreList[i].s && scoreList[i].getSum() == 10 -> {
                        totalScore += scoreList[i].getSum()
                        totalScore += scoreList[i + 1]?.first
                    }
                    else -> totalScore += scoreList[i].getSum()
                }
            }
            println(totalScore)
        }


    }

    private fun initScore(inputScore: MutableList<String>): ArrayList<Score> {
        val scoreList = ArrayList<Score>()
        val size = inputScore.size
        var i = 0
        while (i < size) {
            if (inputScore[i] == "A") {
                scoreList.add(Score(10, 0, true))
                i++
            } else {
                if ((inputScore[i].toInt() + inputScore[i + 1].toInt()) > 10) {
                    throw Exception("error score ${inputScore[i]} ${inputScore[i+1]}")
                } else {
                    scoreList.add(Score(inputScore[i].toInt(), inputScore[i + 1].toInt(), false))
                    i += 2
                }
            }
        }
        println(scoreList)
        return scoreList
    }

}

data class Score(val first: Int, val second: Int, val s: Boolean) {

    fun getSum(): Int {
        return first + second
    }

}