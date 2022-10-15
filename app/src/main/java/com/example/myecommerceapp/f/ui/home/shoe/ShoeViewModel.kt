package com.example.myecommerceapp.f.ui.home.shoe

import androidx.lifecycle.ViewModel
import com.example.myecommerceapp.f.domain.ShoeModel
import com.example.myecommerceapp.f.domain.ShoeModelRepository
import com.example.myecommerceapp.f.domain.ShoeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Implemented as per each model.
 * Using shared ViewModel is fine too
 * @see ShoeModelViewModel
 */

// we might want an Id as param instead, if you insist on each ViewModel that is

@HiltViewModel
class ShoeViewModel @Inject constructor(
	private val repository: ShoeRepository
) : ViewModel() {
	// we can also combine these Flows into a single data class as state
	fun observeImageForId(id: String): Flow<Int> = repository.observeImageForId(id)
	fun observeFavForId(id: String): Flow<Boolean> = repository.observeFavForId(id)
	fun observeNameForId(id: String): Flow<String> = repository.observeNameForId(id)
	fun observePriceForId(id: String): Flow<Double> = repository.observePriceForId(id)
	fun changeFavForId(id: String, fav: Boolean) = repository.changeFavForId(id, fav)

	fun getShoeFront(id: String) = repository.getShoeFront(id)
	fun getShoeBack(id: String) = repository.getShoeBack(id)
	fun getShoeSide(id: String) = repository.getShoeSide(id)
}

class ShoeModelViewModel(
	private val repository: ShoeModelRepository
) : ViewModel() {
	fun observeModel(id: String): Flow<ShoeModel> = repository.observeModelForId(id)
}