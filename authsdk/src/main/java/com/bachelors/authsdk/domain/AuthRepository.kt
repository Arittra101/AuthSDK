package com.bachelors.authsdk.domain

import com.bachelors.authsdk.data.response.UserData
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun signIn(email: String, password: String, username: String): Flow<UserData?>
}


