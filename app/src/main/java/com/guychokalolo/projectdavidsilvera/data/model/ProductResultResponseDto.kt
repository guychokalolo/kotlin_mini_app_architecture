package com.guychokalolo.projectdavidsilvera.data.model

import com.squareup.moshi.Json

data class ProductResultResponseDto(
    @field: Json(name = "status")
    val status: Int,
    @field:Json(name = "product")
    val product: ProductResponseDto?
)
