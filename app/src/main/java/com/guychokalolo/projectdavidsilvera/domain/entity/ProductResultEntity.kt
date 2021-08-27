package com.guychokalolo.projectdavidsilvera.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductResultEntity(
    val status: Int,
    val product: ProductEntity?
) : Parcelable
