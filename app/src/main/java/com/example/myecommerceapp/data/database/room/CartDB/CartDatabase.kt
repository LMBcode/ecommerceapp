package com.example.myecommerceapp.data.database.room.CartDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myecommerceapp.domain.model.CartItem


@Database(entities = [CartItem::class], version = 1)
abstract class CartDatabase : RoomDatabase(){
    abstract fun cartDao() : CartDao
}