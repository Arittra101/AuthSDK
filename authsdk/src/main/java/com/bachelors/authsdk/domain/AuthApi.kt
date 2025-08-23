package com.bachelors.authsdk.domain

import com.bachelors.authsdk.data.request.AuthSignReq
import com.bachelors.authsdk.data.response.AuthResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("api/signin")
    suspend fun signIn(@Body authSignReq: AuthSignReq): AuthResponse
}