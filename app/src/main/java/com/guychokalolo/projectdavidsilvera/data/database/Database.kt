package com.guychokalolo.projectdavidsilvera.data.database

import android.content.Context
import androidx.room.Room

fun createDatabase(appContext: Context) : AppDatabase =
    Room.databaseBuilder(appContext, AppDatabase::class.java, "food").build()

fun createProductDao(database: AppDatabase) = database.productDao()