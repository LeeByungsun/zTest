package com.test.filtertest.vo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ShopVo(
    @SerializedName("0") var score: Int,
    @SerializedName("n") var name: Int,
    @SerializedName("u") var url: Int,
    @SerializedName("S") var style: Int,
    @SerializedName("A") var age: AgeVo


    ) : Serializable