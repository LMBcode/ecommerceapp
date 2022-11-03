package com.example.myecommerceapp.navigation

import android.util.Log
import androidx.compose.runtime.Composable

const val SHOE_ID = "shoeID"
const val SHOE_NAME = "shoeName"
const val SHOE_IMAGE = "shoeImage"
const val SHOE_PRICE = "shoePrice"
const val SHOE_FRONT = "shoeFront"
const val SHOE_BACK = "shoeBack"
const val SHOE_SIDE = "shoeSide"
const val SHOE_LOGO = "shoeLogo"
const val SHOE_BRAND = "shoeBrand"
const val SHOE_QUANTITY = "shoeQuantity"

sealed class EcommerceDestinations(val route : String){
    object LoginScreen : EcommerceDestinations("login_screen")
    object DetailScreen : EcommerceDestinations("detail_screen/{$SHOE_ID}/{$SHOE_NAME}/{$SHOE_IMAGE}/{$SHOE_PRICE}/{$SHOE_FRONT}/{$SHOE_BACK}/{$SHOE_SIDE}/{$SHOE_BRAND}/{$SHOE_QUANTITY}")
    fun passToDetailScreen(id:Int?,name : String?, image : Int?, price:String?, shoeFrontSide:Int?, shoeBackSide :Int?, shoeSide:Int?,shoeBrand: String?,shoeQuantity :Int?) : String{
        Log.d("LOG","detail_screen/$name/$image/$price/$shoeFrontSide/$shoeBackSide/$shoeSide/$shoeBrand/$shoeQuantity")
        return "detail_screen/$id/$name/$image/$price/$shoeFrontSide/$shoeBackSide/$shoeSide/$shoeBrand/$shoeQuantity"
    }
    object CategoryScreen : EcommerceDestinations("category_screen/{$SHOE_BRAND}/{$SHOE_LOGO}")
    fun passToCategoryScreen(shoeBrand : String?,shoeLogo : Int?) : String{
        return "category_screen/$shoeBrand/$shoeLogo"
    }
    object SplashScreen : EcommerceDestinations("splash_screen")
    object RegisterScreen : EcommerceDestinations("register_screen")
}

