package com.example.myecommerceapp.domain.utils

import com.example.myecommerceapp.domain.model.CartItem
import com.example.myecommerceapp.domain.model.Shoe

data class ShoesState(
    val shoes : List<Shoe> = emptyList(),
    val shoeOrder : ShoeOrder = ShoeOrder.Brand(OrderType.Ascending)
)

data class ItemState(
    val items : List<CartItem> = emptyList()
)
