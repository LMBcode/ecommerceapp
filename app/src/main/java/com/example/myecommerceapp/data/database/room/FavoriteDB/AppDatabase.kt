package com.example.myecommerceapp.data.database.room.FavoriteDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myecommerceapp.data.database.room.FavoriteDB.ShoeDao
import com.example.myecommerceapp.domain.model.Shoe


@Database(entities = [Shoe::class], version = 5)
abstract class AppDatabase : RoomDatabase(){
    abstract fun shoeDao() : ShoeDao
}