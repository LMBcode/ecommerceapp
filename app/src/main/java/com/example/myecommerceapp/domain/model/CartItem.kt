package com.example.myecommerceapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Cart")
data class CartItem(
    @PrimaryKey(autoGenerate = true)
    val id : Int ?= null,
    val name : String ?=null,
    val image : Int ?=null,
    var price : String ?=null,
    val size : Int ? = null,
    val brand : String ? = null,
    var quantity : Int = 1,
    var totalPrice : String?
)
