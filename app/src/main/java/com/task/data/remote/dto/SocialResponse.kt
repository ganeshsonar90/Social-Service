package com.task.data.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class SocialResponse {

    @SerializedName("data")
    @Expose
    val data: Data? = null
    @SerializedName("Message")
    @Expose
    val message: String = ""
    @SerializedName("Status")
    @Expose
    val status: Int = 0

}