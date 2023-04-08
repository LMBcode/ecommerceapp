package com.example.myecommerceapp.domain.model

import com.example.myecommerceapp.R


object ShoeProvider {
        fun getShoes() : List<Shoe> {
            return listOf(
                Shoe(
                    1,
                    "NIKE AIR FORCE 1 WHITE",
                    R.drawable.whiteaf1,
                    "NIKE",
                    "119.99",
                    R.drawable.af1frontside,
                    R.drawable.backviewaf1,
                    R.drawable.suelaaf1,
                    false
                ),
                Shoe(
                    2,
                    "ADIDAS FORUM MID",
                    R.drawable.forummidadidas,
                    "ADIDAS",
                    "120.99",
                    R.drawable.forummidfront,
                    R.drawable.forummidadidas,
                    R.drawable.forumlowsuela,
                    false
                ),
                Shoe(
                    3,
                    "Smash v2 Trainers",
                    R.drawable.smash_v2,
                    "PUMA",
                    "54.94",
                    R.drawable.smashfront,
                    R.drawable.smashback,
                    R.drawable.smashsuela,
                    false
                ),
                Shoe(
                    4,
                    "AIR JORDAN 1 RETRO",
                    R.drawable.aj1retro,
                    "NIKE",
                    "169.99",
                    R.drawable.aj1front,
                    R.drawable.aj1back,
                    R.drawable.aj1suela,
                    false
                ),
                Shoe(
                    5,
                    "NEW BALANCE 550",
                    R.drawable.newbalance,
                    "NEW BALANCE",
                    "150.99",
                    R.drawable.newbalancefront,
                    R.drawable.newbba,
                    R.drawable.newbalancesuela,
                    false
                ),
                Shoe(
                    6,
                    "Stan Smith",
                    R.drawable.stansmith,
                    "ADIDAS",
                    "150.99",
                    R.drawable.stansmithfront,
                    R.drawable.stansmith,
                    R.drawable.stansmithsuela,
                    false
                )
            ).take(8)
        }
    }
