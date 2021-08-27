package com.guychokalolo.projectdavidsilvera.data.repository

import com.guychokalolo.projectdavidsilvera.data.network.api.RemoteApi
import com.guychokalolo.projectdavidsilvera.data.database.ProductDao
import com.guychokalolo.projectdavidsilvera.data.mapper.toProductEntity
import com.guychokalolo.projectdavidsilvera.data.mapper.toProductResultEntity
import com.guychokalolo.projectdavidsilvera.domain.entity.ProductEntity
import com.guychokalolo.projectdavidsilvera.domain.entity.ProductResultEntity
import com.guychokalolo.projectdavidsilvera.domain.repository.ProductRepository

class ProductRepositoryImp(
    private val remoteApi: RemoteApi,
    private val productDao: ProductDao
) : ProductRepository {

    override fun getCachedProduct(barcode: String): ProductEntity? {
        return productDao.findProduct(barcode)?.toProductEntity()
    }

    override suspend fun getFetchProduct(barcode: String): ProductResultEntity {
        val productResultResponse = remoteApi.getProduct(barcode)
        val product = productResultResponse.product
        if (product != null) {
            productDao.insertAllProduct(product)
        }
        return productResultResponse.toProductResultEntity()
    }

    override fun getAllCachedProduct(): List<ProductEntity> {
        return productDao.getAll().map { it.toProductEntity() }

    }
}