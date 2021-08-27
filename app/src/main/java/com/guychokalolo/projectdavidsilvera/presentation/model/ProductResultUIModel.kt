package com.guychokalolo.projectdavidsilvera.presentation.model

import com.guychokalolo.projectdavidsilvera.domain.entity.ProductEntity

data class ProductResultUIModel(
    val status: Int,
    val product: ProductEntity?
)
