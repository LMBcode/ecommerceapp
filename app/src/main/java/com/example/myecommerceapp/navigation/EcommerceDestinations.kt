package com.example.myecommerceapp.navigation

import androidx.compose.runtime.Composable

const val SHOE_NAME = "shoeName"
const val SHOE_IMAGE = "shoeImage"
const val SHOE_PRICE = "shoePrice"
const val SHOE_FRONT = "shoeFront"
const val SHOE_BACK = "shoeBack"
const val SHOE_SIDE = "shoeSide"

sealed class EcommerceDestinations(val route : String){
    object LoginScreen : EcommerceDestinations("login_screen")
    object DetailScreen : EcommerceDestinations("detail_screen/{$SHOE_NAME}/{$SHOE_IMAGE}/{$SHOE_PRICE}/{$SHOE_FRONT}/{$SHOE_BACK}/{$SHOE_SIDE}")
    fun passNameAndImage(name : String , image : Int,price:String,shoeFrontSide:Int,shoeBackSide :Int,shoeSide:Int) : String{
        return "detail_screen/$name/$image/$price/$shoeFrontSide/$shoeBackSide/$shoeSide"
    }
    object HomeScreen : EcommerceDestinations("home_screen")
    object SplashScreen : EcommerceDestinations("splash_screen")
    object RegisterScreen : EcommerceDestinations("register_screen")
}

