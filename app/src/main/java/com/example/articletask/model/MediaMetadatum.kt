package com.example.articletask.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MediaMetadatum {

    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("format")
    @Expose
    var format: String? = null
    @SerializedName("height")
    @Expose
    var height: Int = 0
    @SerializedName("width")
    @Expose
    var width: Int = 0
}