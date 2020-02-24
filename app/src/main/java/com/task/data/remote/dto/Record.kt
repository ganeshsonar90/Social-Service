package com.task.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Record(
        @SerializedName("collectedValue")
        val collectedValue: Int,
        @SerializedName("endDate")
        val endDate: String,
        @SerializedName("Id")
        val id: Int,
        @SerializedName("mainImageURL")
        val mainImageURL: String,
        @SerializedName("shortDescription")
        val shortDescription: String,
        @SerializedName("startDate")
        val startDate: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("totalValue")
        val totalValue: Int
)