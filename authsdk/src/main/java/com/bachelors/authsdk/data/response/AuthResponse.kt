package com.bachelors.authsdk.data.response

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("data") val data: UserData? = null,
) : BaseResponse()