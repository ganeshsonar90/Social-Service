package com.task.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Data(
        @SerializedName("Records")
        val records: List<Record>,
        @SerializedName("TotalRecords")
        val totalRecords: Int
)