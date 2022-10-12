package com.example.myecommerceapp.screens.homeScreen.model

import com.example.myecommerceapp.R


object ShoeObject {
        fun getShoes() : List<ShoeModel> {
            return listOf(
                ShoeModel(
                    "NIKE AIR FORCE 1 WHITE",
                    R.drawable.whiteaf1,
                    "",
                    119.99,
                    R.drawable.af1frontside,
                    R.drawable.backviewaf1,
                    R.drawable.suelaaf1
                ),
                ShoeModel(
                    "ADIDAS FORUM MID",
                    R.drawable.forummidadidas,
                    "",
                    120.00,
                    R.drawable.forummidfront,
                    R.drawable.forummidadidas,
                    R.drawable.forumlowsuela
                ),
                ShoeModel(
                    "Smash v2 Trainers",
                    R.drawable.smash_v2,
                    "",
                    54.94,
                    R.drawable.smashfront,
                    R.drawable.smashback,
                    R.drawable.smashsuela
                ),
                ShoeModel(
                    "AIR JORDAN 1 RETRO",
                    R.drawable.aj1retro,
                    "",
                    169.99,
                    R.drawable.aj1front,
                    R.drawable.aj1back,
                    R.drawable.aj1suela
                ),
                ShoeModel(
                    "NEW BALANCE 550",
                    R.drawable.newbalance,
                    "",
                    150.00,
                    R.drawable.newbalancefront,
                    R.drawable.newbba,
                    R.drawable.newbalancesuela
                ),
                ShoeModel(
                    "Stan Smith",
                    R.drawable.stansmith,
                    "",
                    150.00,
                    R.drawable.stansmithfront,
                    R.drawable.stansmith,
                    R.drawable.stansmithsuela
                )
            )
        }
    }
