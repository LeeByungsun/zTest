package com.test.loginTest.vo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MallVo(
    @SerializedName("week") var week: String,
    @SerializedName("list") var list: ArrayList<ShopVo>
) : Serializable

data class AgeVo(
    @SerializedName("A") var list: ArrayList<Int>
) : Serializable

data class ShopVo(
    @SerializedName("0") var score: Int,
    @SerializedName("n") var name: Int,
    @SerializedName("u") var url: Int,
    @SerializedName("S") var style: Int,
    @SerializedName("A") var age: AgeVo
) : Serializable