package com.guychokalolo.projectdavidsilvera.presentation.feature.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.guychokalolo.projectdavidsilvera.domain.usecase.UserUseCase

class HomeViewModel(private val userUseCase: UserUseCase) : ViewModel() {
    val scoreUpdateEvent = userUseCase.scoreUpdateEvent.asLiveData()
    fun getScore() = userUseCase.getScore()
}