package com.guychokalolo.projectdavidsilvera.data.network.api

import android.app.Application
import android.content.Context
import com.guychokalolo.projectdavidsilvera.common.constant.Constant

interface LocalApi {
    fun saveScore(score: Int)
    fun getScore(): Int
}

class LocalApiImpl(appContext: Application) : LocalApi {
    private val sharedPreferences =
        appContext.getSharedPreferences(Constant.PREFERENCE_FILE_NAME, Context.MODE_PRIVATE)

    override fun saveScore(score: Int) =
        sharedPreferences.edit().putInt(Constant.SCORE_KEY, score).apply()

    override fun getScore(): Int = sharedPreferences.getInt(Constant.SCORE_KEY, 0)
}