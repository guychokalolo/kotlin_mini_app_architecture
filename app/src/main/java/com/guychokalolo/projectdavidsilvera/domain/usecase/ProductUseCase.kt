package com.guychokalolo.projectdavidsilvera.domain.usecase


import android.content.res.Resources
import com.guychokalolo.projectdavidsilvera.domain.entity.ProductEntity
import com.guychokalolo.projectdavidsilvera.domain.repository.ProductRepository
import com.guychokalolo.projectdavidsilvera.domain.repository.UserRepository
import com.guychokalolo.projectdavidsilvera.domain.resource.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow


class ProductUseCase(
    private val productRepository: ProductRepository,
    private val userRepository: UserRepository
) {
    fun getProduct(barcode: String) = flow<Resource<ProductEntity>> {
        val cachedProduct = productRepository.getCachedProduct(barcode)
        if (cachedProduct != null){
            emit(Resource.success(cachedProduct))
        }else{
            val data = productRepository.getFetchProduct(barcode)
            val product = data.product ?: throw Resources.NotFoundException()
            userRepository.updateScore(product)
            emit(Resource.success(product))
        }
    }.catch {
        emit(Resource.failure(it))
    }

    fun getAllProduct() = flow<Resource<List<ProductEntity>>> {
        emit(Resource.success(productRepository.getAllCachedProduct()))
    }.catch {
        emit(Resource.failure(it))
    }
}