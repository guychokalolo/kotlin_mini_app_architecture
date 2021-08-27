package com.guychokalolo.projectdavidsilvera.presentation.model

data class ProductUIModel(
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
)
