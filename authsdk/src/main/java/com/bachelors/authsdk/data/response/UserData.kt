package com.bachelors.authsdk.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    @SerializedName("uid") val userId: Int? = null,

    @SerializedName("uname") val username: String? = null,

    @SerializedName("token") val token: String? = null,

    @SerializedName("password") val passwordHash: String? = null,

    @SerializedName("email") val email: String? = null
) : Parcelable