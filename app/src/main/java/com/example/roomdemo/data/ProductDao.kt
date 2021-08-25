package com.example.roomdemo.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert
    fun insert(p: Product)

    @Query ("select * from product_table")
    fun getAll(): List<Product>

    @Query ("select * from product_table Where price < :price")
    fun getPriceLessThan(price:Double) :List<Product>
}