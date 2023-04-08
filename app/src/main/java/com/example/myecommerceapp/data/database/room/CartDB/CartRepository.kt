package com.example.myecommerceapp.data.database.room.CartDB

import com.example.myecommerceapp.domain.model.CartItem
import kotlinx.coroutines.flow.Flow

interface CartRepository {

     fun getCartsFromDB() : Flow<List<CartItem>>

    suspend fun addCartToDB(cartItem: CartItem)

    suspend fun deleteCartFromDB(cartItem: CartItem)

    suspend fun updateCart(cartItem: CartItem)

    suspend fun deleteAll()



}