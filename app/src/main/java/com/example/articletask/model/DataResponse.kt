package com.example.articletask.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataResponse {

    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("copyright")
    @Expose
    val copyright: String? = null
    @SerializedName("num_results")
    @Expose
    val numResults: Int = 0
    @SerializedName("results")
    @Expose
    val results: List<Result>? = null
}