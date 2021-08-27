package com.guychokalolo.projectdavidsilvera.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.guychokalolo.projectdavidsilvera.data.model.ProductResponseDto

@Database(entities = [ProductResponseDto::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

}