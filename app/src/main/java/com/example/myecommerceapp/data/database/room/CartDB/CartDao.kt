package com.example.myecommerceapp.data.database.room.CartDB

import androidx.room.*
import com.example.myecommerceapp.domain.model.CartItem
import com.example.myecommerceapp.domain.model.Shoe
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Query("SELECT * FROM cart")
    fun getAll() : Flow<List<CartItem>>

    @Query("SELECT * FROM cart WHERE id = :id ")
    suspend fun getItem(id : Int) : CartItem?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: CartItem)

    @Update
    suspend fun updateItem(item:CartItem)

    @Delete
    suspend fun deleteItem(item: CartItem)

    @Query("DELETE   FROM cart")
    suspend fun deleteAll()





}