package com.example.myecommerceapp.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myecommerceapp.domain.model.CartItem
import java.math.BigDecimal


class CalculateViewModel() : ViewModel() {

    val _quantity : MutableState<Int> = mutableStateOf(1)
     val _price : MutableState<BigDecimal> = mutableStateOf("0.00".toBigDecimal())
    val _totalPrice : MutableState<BigDecimal> = mutableStateOf("0.00".toBigDecimal())



    fun calculatePrice(quantity : Int, price : BigDecimal){
        _quantity.value = quantity
        _price.value = price.times(quantity.toBigDecimal())
    }

    fun totalPrice(items: List<CartItem> = emptyList()){
        _totalPrice.value = items.sumOf { it.totalPrice!!.toBigDecimal() }
    }


}