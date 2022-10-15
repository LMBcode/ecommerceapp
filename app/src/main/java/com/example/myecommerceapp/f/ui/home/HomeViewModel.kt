package com.example.myecommerceapp.f.ui.home

import androidx.lifecycle.ViewModel
import com.example.myecommerceapp.f.domain.ShoeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
	private val shoeRepository: ShoeRepository
): ViewModel() {
	fun observeShoeList(): Flow<List<String>> = shoeRepository.observeAvailableShoes()
}