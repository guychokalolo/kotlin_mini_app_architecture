package com.guychokalolo.projectdavidsilvera.data.repository

import com.guychokalolo.projectdavidsilvera.data.network.api.LocalApi
import com.guychokalolo.projectdavidsilvera.domain.entity.ProductEntity
import com.guychokalolo.projectdavidsilvera.domain.entity.ScoreUpdateEventEntity
import com.guychokalolo.projectdavidsilvera.domain.repository.UserRepository
import kotlinx.coroutines.flow.MutableSharedFlow

class UserRepositoryImpl(private val localApi: LocalApi) : UserRepository {
    override val scoreUpdatedEvent =  MutableSharedFlow<ScoreUpdateEventEntity>()

    override fun getScore(): Int = localApi.getScore()

    override suspend fun updateScore(productEntity: ProductEntity) {
       val score = localApi.getScore() + productEntity.score()
        localApi.saveScore(score)
        scoreUpdatedEvent.emit(ScoreUpdateEventEntity(score))
    }
}