package com.guychokalolo.projectdavidsilvera.data.database

import androidx.room.*
import com.guychokalolo.projectdavidsilvera.data.model.ProductResponseDto

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAll(): List<ProductResponseDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllProduct(vararg product: ProductResponseDto)

    @Query("SELECT * FROM product WHERE code = :barcode LIMIT 1")
    fun findProduct(barcode: String): ProductResponseDto?

    @Delete
    fun deleteProduct(product: ProductResponseDto)
}