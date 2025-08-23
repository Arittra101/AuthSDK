package com.bachelors.authsdk.data

import com.bachelors.authsdk.data.request.AuthSignReq
import com.bachelors.authsdk.data.response.UserData
import com.bachelors.authsdk.domain.AuthApi
import com.bachelors.authsdk.domain.AuthRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AuthRepositoryImp(
    private val authApi: AuthApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : AuthRepository {

    override fun signIn(email: String, password: String, username: String): Flow<UserData?> {
        return flow {
            val result = authApi.signIn(AuthSignReq(email, password, username)).data
            emit(result)
        }.flowOn(dispatcher)
    }
}