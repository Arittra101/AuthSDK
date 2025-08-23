package com.bachelors.authsdk.data.response

data class AuthSuccessResult(
    val message : String,
    val data: UserData?=null,
)
