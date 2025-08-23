package com.bachelors.authsdk.data.response

import com.google.gson.annotations.SerializedName

open class BaseResponse(
    @SerializedName("status") val status: String? = null,
    @SerializedName("code") val code: String? = null,
    @SerializedName("message") val message: String? = null,
)