package com.example.myecommerceapp.f.data

import com.example.myecommerceapp.f.domain.ShoeRepository
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)
object Module {

	@Provides
	@Singleton
	fun provideShoeRepository(): ShoeRepository = RealShoeRepository()
}