package com.guychokalolo.projectdavidsilvera.data.network.api

import com.guychokalolo.projectdavidsilvera.data.model.ProductResultResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteApi {
    @GET("product/{barcode}")
    suspend fun getProduct(@Path("barcode") barcode: String) : ProductResultResponseDto
}
