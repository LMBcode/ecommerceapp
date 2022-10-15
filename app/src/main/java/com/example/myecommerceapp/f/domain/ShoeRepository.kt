package com.example.myecommerceapp.f.domain

import kotlinx.coroutines.flow.Flow

interface ShoeRepository {
	fun observeAvailableShoes(): Flow<List<String>>
	fun observeImageForId(id: String): Flow<Int>
	fun observeFavForId(id: String): Flow<Boolean>
	fun observeNameForId(id: String): Flow<String>
	fun observePriceForId(id: String): Flow<Double>
	fun changeFavForId(id: String, fav: Boolean)

	fun getShoeFront(id: String): Int
	fun getShoeBack(id: String): Int
	fun getShoeSide(id: String): Int
}

data class ShoeModel(
	val id: String,
	val name: String,
	val image: Int,
	val description: String,
	val fav: Boolean,
	// floating point is a bad Idea to represent currency, better represent it as a class instead
	val price: Double,
	val front: Int,
	val back: Int,
	val side: Int,
)

// we can also observe id then return the model mapping
interface ShoeModelRepository {
	fun observeAvailableShoes(): Flow<List<String>>
	fun observeModelForId(id: String): Flow<ShoeModel>
}

