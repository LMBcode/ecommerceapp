package com.example.myecommerceapp.di

import android.content.Context
import androidx.room.Room
import com.example.myecommerceapp.data.database.room.FavoriteDB.AppDatabase
import com.example.myecommerceapp.data.database.room.FavoriteDB.ShoeRepository
import com.example.myecommerceapp.data.database.room.FavoriteDB.ShoeRepositoryImpl
import com.example.myecommerceapp.data.database.room.usecase.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    fun provideShoeDao(appDatabase: AppDatabase)  = appDatabase.shoeDao()

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context) =
        Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "ShoeDB"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun shoeRepository(db : AppDatabase) : ShoeRepository {
        return ShoeRepositoryImpl(db.shoeDao())
    }

    @Provides
    @Singleton
    fun shoeUseCases(repository: ShoeRepository) : ShoeUseCase{
        return ShoeUseCase(
            getShoes = GetShoes(repository),
            deleteShoe = DeleteShoe(repository),
            insertShoe = InsertShoe(repository),
            getShoe = GetShoe(repository)
        )
    }




}