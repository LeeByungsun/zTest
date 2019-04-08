package com.test.filtertest.vo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AgeVo(
    @SerializedName("A") var list: ArrayList<Int>
) : Serializable