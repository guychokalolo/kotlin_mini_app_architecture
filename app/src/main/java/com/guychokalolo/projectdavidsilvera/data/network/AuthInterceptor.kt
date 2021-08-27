package com.guychokalolo.projectdavidsilvera.data.network

import android.accounts.NetworkErrorException
import com.guychokalolo.projectdavidsilvera.common.error.NoInternetConnectionException
import com.guychokalolo.projectdavidsilvera.common.error.WSException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.lang.Exception
import java.util.concurrent.ExecutionException

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        //here we are going to override the way of making the retrofit request
        val request = chain.request()
        val response : Response
        try {
            //Build request
            val builder = request.newBuilder()
            //executed the request
            response = chain.proceed(builder.build())
        } catch (exception: Exception){
            //if we have query errors
            throw when(exception){
                is ExecutionException -> NoInternetConnectionException()
                is IOException -> NoInternetConnectionException()
                else -> NetworkErrorException(exception)
            }
        }
        //if the answer is not successful
        if (!response.isSuccessful) {
            throw WSException(response)
        }
        return response
    }
}