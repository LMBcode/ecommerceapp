package com.example.myecommerceapp.domain.utils

sealed class OrderType{
    object Ascending : OrderType()
    object Descending :OrderType()
}
