package com.guychokalolo.projectdavidsilvera.presentation.feature.main.viewmodel

import androidx.lifecycle.*
import com.guychokalolo.projectdavidsilvera.domain.entity.ProductEntity
import com.guychokalolo.projectdavidsilvera.domain.resource.Resource
import com.guychokalolo.projectdavidsilvera.domain.usecase.ProductUseCase
import com.guychokalolo.projectdavidsilvera.presentation.mapper.contextIO

class HistoryViewModel(private val productUseCase: ProductUseCase) : ViewModel() {
    private val mutableProductsParams = MutableLiveData<GetAllProductsParams>()
    val productsResult: LiveData<Resource<List<ProductEntity>>> = mutableProductsParams.switchMap {
        productUseCase.getAllProduct().asLiveData(contextIO())
    }

    fun getAllProducts() {
        mutableProductsParams.value = GetAllProductsParams()
    }

    private class GetAllProductsParams
}