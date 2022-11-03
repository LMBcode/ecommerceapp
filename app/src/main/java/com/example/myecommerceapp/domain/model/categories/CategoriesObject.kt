package com.example.myecommerceapp.domain.model.categories

import com.example.myecommerceapp.R
import com.example.myecommerceapp.domain.model.Shoe

object CategoriesObject {

    fun getCategories() : List<Shoe>{

        return listOf(
            Shoe(
                shoeBrand = "NIKE",
                shoeLogo = R.drawable.nikeeh
            ),
            Shoe(
                shoeBrand = "ADIDAS",
                shoeLogo = R.drawable.adidas
            ),
            Shoe(
                shoeBrand = "PUMA",
                shoeLogo = R.drawable.pumalogo
            ),
            Shoe(
                shoeBrand = "NEW BALANCE",
                shoeLogo = R.drawable.newbalancelogo
            )
        )
    }



}