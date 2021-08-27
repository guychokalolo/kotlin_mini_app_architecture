package com.guychokalolo.projectdavidsilvera.data.network

import com.guychokalolo.projectdavidsilvera.BuildConfig
import com.guychokalolo.projectdavidsilvera.common.constant.Constant
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.jvm.internal.Intrinsics

fun createApiClient(): Retrofit =
    Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(wsHttpClient())
        .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
        .build()

fun wsHttpClient(): OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor())
        .callTimeout(Constant.CALL_TIMEOUTS_SECONDS, TimeUnit.SECONDS)
        .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE))
        .build()