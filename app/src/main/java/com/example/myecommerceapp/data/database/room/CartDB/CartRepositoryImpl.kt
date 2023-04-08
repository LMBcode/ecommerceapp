package com.example.myecommerceapp.data.database.room.CartDB

import com.example.myecommerceapp.domain.model.CartItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(private val cartDao: CartDao) : CartRepository{
    override  fun getCartsFromDB(): Flow<List<CartItem>> {
       return  cartDao.getAll()
    }

    override suspend fun addCartToDB(cartItem: CartItem) {
        cartDao.insertItem(cartItem)
    }

    override suspend fun deleteCartFromDB(cartItem: CartItem) {
        cartDao.deleteItem(cartItem)
    }

    override suspend fun updateCart(cartItem: CartItem) {
        cartDao.updateItem(cartItem)
    }

    override suspend fun deleteAll() {
        cartDao.deleteAll()
    }
}