package com.guychokalolo.projectdavidsilvera.presentation.feature.main.view

import com.guychokalolo.projectdavidsilvera.domain.entity.ProductEntity

interface OnProductClickListener {
    fun onProductClicked(productEntity: ProductEntity)
}