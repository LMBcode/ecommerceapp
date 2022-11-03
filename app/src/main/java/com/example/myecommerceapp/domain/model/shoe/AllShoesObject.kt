package com.example.myecommerceapp.domain.model.shoe

import com.example.myecommerceapp.R
import com.example.myecommerceapp.domain.model.Shoe

object AllShoesObject {
    fun getShoes() : List<Shoe> {
        return listOf(
            Shoe(
                8,
                "NIKE AIR FORCE 1",
                R.drawable.nikeaf1b,
                "NIKE",
                "119.99",
                R.drawable.frontsideblacklogo,
                R.drawable.backside,
                R.drawable.suelabl,
                false,
                quantity = 1
            ),

            Shoe(
                1,
                "NIKE AIR FORCE 1 WHITE",
                R.drawable.whiteaf1,
                "NIKE",
                "119.99",
                R.drawable.af1frontside,
                R.drawable.backviewaf1,
                R.drawable.suelaaf1,
                false,
                quantity = 1
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
                false,
                quantity = 1
            ),

            Shoe(
                7,
                "BLACK AIR FORCES",
                R.drawable.blackaf,
                "NIKE",
                "119.99",
                R.drawable.blackaffront,
                R.drawable.blackafback,
                R.drawable.blackafsuela,
                false,
                quantity = 1
            ),

            Shoe(
                9,
                "YEEZY 350",
                R.drawable.ay350,
                "ADIDAS",
                "220.99",
                R.drawable.yeezyfront,
                R.drawable.yeezyback,
                R.drawable.yeezysuela,
                false,
                quantity = 1
            ),

            Shoe(
                10,
                "JORDAN 3 RETRO",
                R.drawable.jordan3retro,
                "NIKE",
                "230.99",
                R.drawable.jordan3retrofront,
                R.drawable.jordan3back,
                R.drawable.jordan3retrosuela,
                false,
                quantity = 1
            ),
            Shoe(
                5,
                "NEW BALANCE 550",
                R.drawable.newbalance,
                "NEW BALANCE",
                "150.00",
                R.drawable.newbalancefront,
                R.drawable.newbba,
                R.drawable.newbalancesuela,
                false,
                quantity = 1
            ),
            Shoe(
                11,
                "NEW BALANCE 530",
                R.drawable.newb530,
                "NEW BALANCE",
                "110.00",
                R.drawable.newb350front,
                R.drawable.newb350back,
                R.drawable.newb350suela,
                false,
                quantity = 1
            ),
            Shoe(
                12,
                "NEW BALANCE 327",
                R.drawable.newb327,
                "NEW BALANCE",
                "110.00",
                R.drawable.newb327front,
                R.drawable.newb327back,
                R.drawable.newb327suela,
                false,
                quantity = 1
            ),
            Shoe(
                13,
                "NEW BALANCE BB550",
                R.drawable.newbb550,
                "NEW BALANCE",
                "130.00",
                R.drawable.newbb550front,
                R.drawable.newbb550back,
                R.drawable.newbb550suela,
                false,
                quantity = 1
            ),
            Shoe(
                6,
                "Stan Smith",
                R.drawable.stansmith,
                "ADIDAS",
                "150.00",
                R.drawable.stansmithfront,
                R.drawable.stansmith,
                R.drawable.stansmithsuela,
                false,
                quantity = 1
            ),

            Shoe(
                14,
                "ADIDAS SUPERSTAR",
                R.drawable.superstar,
                "ADIDAS",
                "110.00",
                R.drawable.superstarfront,
                R.drawable.superstarback,
                R.drawable.superstarback,
                false,
                quantity = 1
            ),

            Shoe(
                2,
                "ADIDAS FORUM MID",
                R.drawable.forummidadidas,
                "ADIDAS",
                "120.00",
                R.drawable.forummidfront,
                R.drawable.forummidadidas,
                R.drawable.forumlowsuela,
                false,
                quantity = 1
            ),

            Shoe(
                17,
                "ADIDAS FORUM LOW",
                R.drawable.forumlow,
                "ADIDAS",
                "120.00",
                R.drawable.forummidfront,
                R.drawable.forumlow,
                R.drawable.forumlowsuela,
                false,
                quantity = 1
            ),

            Shoe(
                18,
                "ADIDAS GAZELLE",
                R.drawable.zapatillagazelle,
                "ADIDAS",
                "100.00",
                R.drawable.zapatillagazellefront,
                R.drawable.zapatillagazelle,
                R.drawable.zapatillagazellesuela,
                false,
                quantity = 1
            ),
            Shoe(
                19,
                "PUMA TUMBLE",
                R.drawable.ca_pro_tumble_trainers,
                "PUMA",
                "70.00",
                R.drawable.frontsidecatumble,
                R.drawable.tumbleback,
                R.drawable.suelatumble,
                false,
                quantity = 1
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
                false,
                quantity = 1
            ),
            Shoe(
                20,
                "Mirage Sneakers",
                R.drawable.miragepuma,
                "PUMA",
                "59.94",
                R.drawable.miragefront,
                R.drawable.mirageback,
                R.drawable.miragesuela,
                false,
                quantity = 1
            )



        )
    }

    fun getNB() : List<Shoe>{
        return listOf(
            Shoe(
                5,
                "NEW BALANCE 550",
                R.drawable.newbalance,
                "NB",
                "150.00",
                R.drawable.newbalancefront,
                R.drawable.newbba,
                R.drawable.newbalancesuela,
                false
            ),
            Shoe(
                11,
                "NEW BALANCE 530",
                R.drawable.newb530,
                "NB",
                "110.00",
                R.drawable.newb350front,
                R.drawable.newb350back,
                R.drawable.newb350suela,
                false
            ),
            Shoe(
                12,
                "NEW BALANCE 327",
                R.drawable.newb327,
                "NB",
                "110.00",
                R.drawable.newb327front,
                R.drawable.newb327back,
                R.drawable.newb327suela,
                false
            ),
            Shoe(
                13,
                "NEW BALANCE BB550",
                R.drawable.newbb550,
                "NB",
                "130.00",
                R.drawable.newbb550front,
                R.drawable.newbb550back,
                R.drawable.newbb550suela,
                false
            )
        )
    }

    fun getPUMA() : List<Shoe>{
        return listOf(
        Shoe(
            19,
            "PUMA TUMBLE",
            R.drawable.ca_pro_tumble_trainers,
            "PUMA",
            "70.00",
            R.drawable.frontsidecatumble,
            R.drawable.tumbleback,
            R.drawable.suelatumble,
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
            20,
            "Mirage Sneakers",
            R.drawable.miragepuma,
            "PUMA",
            "59.94",
            R.drawable.miragefront,
            R.drawable.mirageback,
            R.drawable.miragesuela,
            false
        ))
    }

    fun getADIDAS() : List<Shoe>{
        return listOf(
            Shoe(
                6,
                "Stan Smith",
                R.drawable.stansmith,
                "ADIDAS",
                "150.00",
                R.drawable.stansmithfront,
                R.drawable.stansmith,
                R.drawable.stansmithsuela,
                false
            ),

            Shoe(
                14,
                "ADIDAS SUPERSTAR",
                R.drawable.superstar,
                "ADIDAS",
                "110.00",
                R.drawable.superstarfront,
                R.drawable.superstarback,
                R.drawable.superstarback,
                false
            ),

            Shoe(
                2,
                "ADIDAS FORUM MID",
                R.drawable.forummidadidas,
                "ADIDAS",
                "120.00",
                R.drawable.forummidfront,
                R.drawable.forummidadidas,
                R.drawable.forumlowsuela,
                false
            ),

            Shoe(
                17,
                "ADIDAS FORUM LOW",
                R.drawable.forumlow,
                "ADIDAS",
                "120.00",
                R.drawable.forummidfront,
                R.drawable.forumlow,
                R.drawable.forumlowsuela,
                false
            ),

            Shoe(
                18,
                "ADIDAS GAZELLE",
                R.drawable.zapatillagazelle,
                "ADIDAS",
                "100.00",
                R.drawable.zapatillagazellefront,
                R.drawable.zapatillagazelle,
                R.drawable.zapatillagazellesuela,
                false
            ),
        )
    }

    fun getNIKE() : List<Shoe>{
        return listOf(
            Shoe(
                8,
                "NIKE AIR FORCE 1",
                R.drawable.nikeaf1b,
                "NIKE",
                "119.99",
                R.drawable.frontsideblacklogo,
                R.drawable.backside,
                R.drawable.suelabl,
                false
            ),

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
                7,
                "BLACK AIR FORCES",
                R.drawable.blackaf,
                "NIKE",
                "119.99",
                R.drawable.blackaffront,
                R.drawable.blackafback,
                R.drawable.blackafsuela,
                false
            ),
            
        )
    }
}