package com.guychokalolo.projectdavidsilvera.domain.repository

import com.guychokalolo.projectdavidsilvera.domain.entity.ProductEntity
import com.guychokalolo.projectdavidsilvera.domain.entity.ProductResultEntity

interface ProductRepository {
    fun getCachedProduct(barcode: String): ProductEntity?
    suspend fun getFetchProduct(barcode: String): ProductResultEntity
    fun getAllCachedProduct(): List<ProductEntity>

}