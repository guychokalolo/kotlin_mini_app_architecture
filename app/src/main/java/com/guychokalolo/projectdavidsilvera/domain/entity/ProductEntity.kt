package com.guychokalolo.projectdavidsilvera.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductEntity(
    val id: String,
    val ingredientsText: String,
    val imageUrl: String,
    val code: String,
    val brand: String,
    val genericName: String,
    val labels: String,
    val nutriscoreScore: Int,
    val nutriscoreGrade: String,
    val ecoscoreScore: Int,
    val ecoscoreGrade: String
) : Parcelable {
    fun score() = ecoscoreScore - nutriscoreScore
}
