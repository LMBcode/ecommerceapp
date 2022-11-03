package com.example.myecommerceapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.math.BigDecimal

@Entity
data class Shoe(
    @PrimaryKey val id : Int ?=null,
    val shoeName : String ?= null,
    val shoeImage : Int ?= null,
    val shoeBrand : String ?= null,
    var shoePrice : String ?= null,
    val shoeFrontSide : Int ?= null,
    val shoeBackSide : Int ?= null,
    val shoeSide : Int ?= null,
    val isFavorite : Boolean = false,
    val shoeLogo : Int ?= null,
    var quantity : Int = 1
) : Serializable
