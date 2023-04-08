package com.example.myecommerceapp.data.database.room.FavoriteDB

import com.example.myecommerceapp.domain.model.Shoe
import kotlinx.coroutines.flow.Flow

interface ShoeRepository {
     fun getShoes() : Flow<List<Shoe>>

    suspend fun insertShoe(shoe : Shoe)

    suspend fun deleteShoe(shoe : Shoe)

    suspend fun getShoe(id:Int) : Shoe?
}