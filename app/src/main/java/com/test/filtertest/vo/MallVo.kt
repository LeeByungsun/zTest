package com.test.filtertest.vo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MallVo(
    @SerializedName("week") var week: String,
    @SerializedName("list") var list: ArrayList<ShopVo>
) : Serializable