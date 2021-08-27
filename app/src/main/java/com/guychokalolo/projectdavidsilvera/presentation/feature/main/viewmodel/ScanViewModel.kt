package com.guychokalolo.projectdavidsilvera.presentation.feature.main.viewmodel

import androidx.lifecycle.*
import com.guychokalolo.projectdavidsilvera.domain.entity.ProductEntity
import com.guychokalolo.projectdavidsilvera.domain.resource.Resource
import com.guychokalolo.projectdavidsilvera.domain.usecase.ProductUseCase
import com.guychokalolo.projectdavidsilvera.presentation.mapper.contextIO
import com.guychokalolo.projectdavidsilvera.presentation.model.ProductUIModel

class ScanViewModel(private val productUseCase: ProductUseCase) : ViewModel() {

    private val mutableProduct: MutableLiveData<GetProductParams> = MutableLiveData()
    val productResult: LiveData<Resource<ProductEntity>> = mutableProduct.switchMap {
        productUseCase.getProduct(it.barcode).asLiveData(contextIO())
    }

    fun getProduct(barcode: String) {
        mutableProduct.value = GetProductParams(barcode)
    }

    private class GetProductParams(val barcode: String)
}