package com.bachelors.authsdk

import com.bachelors.authsdk.data.AuthRepositoryImp
import com.bachelors.authsdk.domain.AuthApi
import com.bachelors.authsdk.domain.AuthRepository
import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://firebase-authentication-sable-beta.vercel.app/"

val appSdkModule = module {
    single { provideRetrofit() }

    //create AuthApi Service instance
    factory { provideApiService(get()) }

    //create repository instance
    single<AuthRepository> { AuthRepositoryImp(get()) }

}


fun provideRetrofit(): Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(
        GsonConverterFactory.create(
            GsonBuilder()
                .setLenient()
                .create()
        )
    )
    .build()


fun provideApiService(retrofit: Retrofit): AuthApi =
    retrofit.create(AuthApi::class.java)

