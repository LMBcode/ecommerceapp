package com.example.myecommerceapp.screens.homeScreen.model.categories

import com.example.myecommerceapp.R
import com.example.myecommerceapp.navigation.EcommerceDestinations

object CategoriesObject {

    fun getCategories() : List<CategoriesModel>{

        return listOf(
            CategoriesModel(
                "NIKE",
                EcommerceDestinations.LoginScreen.route,
                R.drawable.nikeeh
            ),
            CategoriesModel(
                "ADIDAS",
                EcommerceDestinations.LoginScreen.route,
                R.drawable.adidas

            ),
            CategoriesModel(
                "PUMA",
                EcommerceDestinations.LoginScreen.route,
                R.drawable.pumalogo
            ),
            CategoriesModel(
                "VANS",
                EcommerceDestinations.LoginScreen.route,
                R.drawable.vanslogo
            ),
            CategoriesModel(
                "REEBOOK",
                EcommerceDestinations.LoginScreen.route,
                R.drawable.reebook
            ),
            CategoriesModel(
                "NB",
                EcommerceDestinations.LoginScreen.route,
                R.drawable.newbalancelogo
            )
        )
    }



}