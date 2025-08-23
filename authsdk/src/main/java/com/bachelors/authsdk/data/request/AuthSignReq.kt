package com.bachelors.authsdk.data.request

import com.google.gson.annotations.SerializedName

data class AuthSignReq(
  @SerializedName("email") val email: String,
  @SerializedName("password") val password: String,
  @SerializedName("uname") val String: String
)
