package com.guychokalolo.projectdavidsilvera.data.mapper

import com.guychokalolo.projectdavidsilvera.data.model.ProductResponseDto
import com.guychokalolo.projectdavidsilvera.data.model.ProductResultResponseDto
import com.guychokalolo.projectdavidsilvera.domain.entity.ProductEntity
import com.guychokalolo.projectdavidsilvera.domain.entity.ProductResultEntity


fun ProductResponseDto.toProductEntity() =
    ProductEntity(
        id,
        ingredientsText,
        imageUrl,
        code,
        brand,
        genericName,
        labels,
        nutriscoreScore,
        nutriscoreGrade,
        ecoscoreScore,
        ecoscoreGrade
    )

fun ProductResultResponseDto.toProductResultEntity() =
    ProductResultEntity(
        status,
        product?.toProductEntity()
    )