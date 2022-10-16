package com.example.myecommerceapp.model

import java.io.Serializable

data class ShoeModel(
    val shoeName : String ?= null,
    val shoeImage : Int ?= null,
    val shoeDescription : String ?= null ,
    val shoePrice : Double ?= null ,
    val shoeFrontSide : Int ?= null ,
    val shoeBackSide : Int ?= null ,
    val shoeSide : Int ?= null ,
    var isFavorite : Boolean ?= null
) : Serializable
