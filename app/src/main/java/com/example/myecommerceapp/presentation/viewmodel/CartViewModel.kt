package com.example.myecommerceapp.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myecommerceapp.data.database.room.CartDB.CartRepository
import com.example.myecommerceapp.domain.model.CartItem
import com.example.myecommerceapp.domain.utils.ItemState
import com.example.myecommerceapp.domain.utils.ShoesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val repo : CartRepository) : ViewModel() {

    val _shoeSize : MutableState<Int> = mutableStateOf(0)
    private val _state = mutableStateOf(ItemState())
    val state : State<ItemState> = _state
    private var getItemsJob : Job? = null
    init {
        getItems()
    }


    fun addItem(item: CartItem) = viewModelScope.launch(Dispatchers.IO){
            repo.addCartToDB(item)
    }
    fun removeItem(item: CartItem) = viewModelScope.launch(Dispatchers.IO){
        repo.deleteCartFromDB(item)
    }

    fun updateItem(item: CartItem) = viewModelScope.launch(Dispatchers.IO){
        repo.updateCart(item)
    }

    fun deleteAll() = viewModelScope.launch(Dispatchers.IO){
        repo.deleteAll()
    }

    private fun getItems() {
        getItemsJob?.cancel()
        getItemsJob = repo.getCartsFromDB()
            .onEach { item->
                _state.value = state.value.copy(
                    items = item
                )
            }
            .launchIn(viewModelScope)

    }




}