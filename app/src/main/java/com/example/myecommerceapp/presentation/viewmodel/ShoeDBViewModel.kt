package com.example.myecommerceapp.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myecommerceapp.data.database.room.usecase.ShoeEvent
import com.example.myecommerceapp.data.database.room.usecase.ShoeUseCase
import com.example.myecommerceapp.domain.utils.ShoesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoeDBViewModel @Inject constructor(private val shoeUseCase: ShoeUseCase) : ViewModel() {


    private val _state = mutableStateOf(ShoesState())
    val state : State<ShoesState> = _state

    private var getShoesJob : Job? = null

    init {
        getShoes()
    }

    fun onEvent(event: ShoeEvent){
        when(event){
            is ShoeEvent.DeleteNote->{
                CoroutineScope(Dispatchers.IO).launch {
                    shoeUseCase.deleteShoe(event.shoe)
                }

            }

            is ShoeEvent.InsertNote ->{
                CoroutineScope(Dispatchers.IO).launch {
                    shoeUseCase.insertShoe(event.shoe)
                }

            }
            else -> {}
        }
    }

    private fun getShoes() {
        getShoesJob?.cancel()
        getShoesJob = shoeUseCase.getShoes()
            .onEach { shoe->
                _state.value = state.value.copy(
                    shoes = shoe
                )
            }
            .launchIn(viewModelScope)

    }


}