package com.guychokalolo.projectdavidsilvera.domain.usecase

import com.guychokalolo.projectdavidsilvera.domain.repository.UserRepository

class UserUseCase(private val userRepository: UserRepository) {
    val scoreUpdateEvent = userRepository.scoreUpdatedEvent
    fun getScore() = userRepository.getScore()
}