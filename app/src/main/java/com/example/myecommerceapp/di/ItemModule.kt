package com.example.myecommerceapp.di

import android.content.Context
import androidx.room.Room
import com.example.myecommerceapp.data.database.room.CartDB.CartDao
import com.example.myecommerceapp.data.database.room.CartDB.CartDatabase
import com.example.myecommerceapp.data.database.room.CartDB.CartRepository
import com.example.myecommerceapp.data.database.room.CartDB.CartRepositoryImpl
import com.example.myecommerceapp.data.database.room.FavoriteDB.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ItemModule {

    @Provides
    @Singleton
    fun provideCartDatabase(@ApplicationContext appContext: Context) =
        Room.databaseBuilder(
            appContext,
            CartDatabase::class.java,
            "ShoeDB"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideItemDao(cartDatabase: CartDatabase) = cartDatabase.cartDao()

    @Provides
    @Singleton
    fun cartRepositorty(db : CartDatabase) : CartRepository{
        return CartRepositoryImpl(db.cartDao())
    }

}