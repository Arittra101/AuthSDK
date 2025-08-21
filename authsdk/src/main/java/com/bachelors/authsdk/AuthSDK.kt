package com.bachelors.authsdk

import android.content.Context
import com.bachelors.authsdk.callback.AuthSdkCallback
import com.bachelors.authsdk.data.AuthSuccessResult

class AuthSDK private constructor() {

    companion object {
        private var INSTANCE: AuthSDK? = null
        fun getInstance(): AuthSDK {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: AuthSDK().also { INSTANCE = it }
            }
        }
    }

    private var config: AuthSDKConfig? = null
    private var appContext: Context? = null

    fun initSDK(context: Context, config: AuthSDKConfig?) {
        this.appContext = context
        this.config = config
    }

    fun getResponse(name:String, callback : AuthSdkCallback){
        callback.onSuccess(AuthSuccessResult(message = "Hello $name"))
    }

}