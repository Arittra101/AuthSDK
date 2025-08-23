package com.bachelors.authsdk.callback

import com.bachelors.authsdk.data.response.AuthError
import com.bachelors.authsdk.data.response.AuthSuccessResult

interface AuthSdkCallback {
    fun onSuccess(result: AuthSuccessResult)
    fun onError(error: AuthError)
}