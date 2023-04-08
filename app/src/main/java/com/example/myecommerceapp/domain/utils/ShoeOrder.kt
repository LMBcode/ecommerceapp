package com.example.myecommerceapp.domain.utils

sealed class ShoeOrder(val orderType: OrderType){
    class Brand(orderType: OrderType) : ShoeOrder(orderType)




}
