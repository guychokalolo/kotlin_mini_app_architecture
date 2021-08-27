package com.guychokalolo.projectdavidsilvera.domain.repository

import com.guychokalolo.projectdavidsilvera.domain.entity.ProductEntity
import com.guychokalolo.projectdavidsilvera.domain.entity.ScoreUpdateEventEntity
import kotlinx.coroutines.flow.MutableSharedFlow

interface UserRepository {
    val scoreUpdatedEvent: MutableSharedFlow<ScoreUpdateEventEntity>
    fun getScore(): Int
    suspend fun updateScore(productEntity: ProductEntity)
}