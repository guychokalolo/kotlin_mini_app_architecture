package com.guychokalolo.projectdavidsilvera.presentation.mapper

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.guychokalolo.projectdavidsilvera.R
import com.guychokalolo.projectdavidsilvera.domain.entity.ProductEntity
import com.guychokalolo.projectdavidsilvera.domain.entity.ProductResultEntity
import com.guychokalolo.projectdavidsilvera.presentation.model.ProductResultUIModel
import com.guychokalolo.projectdavidsilvera.presentation.model.ProductUIModel
import kotlinx.coroutines.Dispatchers

fun Fragment.mainNavController() = requireActivity().findNavController(R.id.fragment)
fun ViewModel.contextIO() = viewModelScope.coroutineContext + Dispatchers.IO

fun ProductEntity.toProductUIModel() =
    ProductUIModel(
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

fun ProductResultEntity.toProductResultUIModel() =
    ProductResultUIModel(status, product)