package com.bachelors.authsdk

import android.content.Context
import com.bachelors.authsdk.callback.AuthSdkCallback
import com.bachelors.authsdk.data.response.AuthSuccessResult
import com.bachelors.authsdk.domain.AuthRepository
import kotlinx.coroutines.flow.firstOrNull
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class AuthSDK private constructor() : KoinComponent {

    private val authRepository: AuthRepository by inject()

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
//        loadKoinModules(appSdkModule)
        startKoin {
            androidContext(context)
            modules(appSdkModule)
        }
    }

    fun getResponse(name: String, callback: AuthSdkCallback) {
        callback.onSuccess(AuthSuccessResult(message = "Hello $name"))
    }

    suspend fun signIn(
        email: String,
        password: String,
        username: String,
        callback: AuthSdkCallback
    ) {
        val result = authRepository.signIn(email, password, username).firstOrNull()
        callback.onSuccess(AuthSuccessResult(message = "Successfully login", data = result))
    }


}