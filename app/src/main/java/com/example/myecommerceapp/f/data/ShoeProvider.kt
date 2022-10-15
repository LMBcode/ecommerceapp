package com.example.myecommerceapp.f.data

import com.example.myecommerceapp.R
import com.example.myecommerceapp.f.domain.ShoeModel

object ShoeProvider {
	val shoeList = listOf(
		ShoeModel(
			id = "1",
			name = "NIKE AIR FORCE 1 WHITE",
			image = R.drawable.whiteaf1,
			description = "",
			fav = false,
			price = 119.99,
			front = R.drawable.af1frontside,
			back = R.drawable.backviewaf1,
			side = R.drawable.suelaaf1,
		),
		ShoeModel(
			id = "2",
			name = "ADIDAS FORUM MID",
			image = R.drawable.forummidadidas,
			description = "",
			fav = false,
			price = 120.00,
			front = R.drawable.forummidfront,
			back = R.drawable.forummidadidas,
			side = R.drawable.forumlowsuela,
		),
		ShoeModel(
			id = "3",
			name = "Smash v2 Trainers",
			image = R.drawable.smash_v2,
			description = "",
			fav = false,
			price = 54.94,
			front = R.drawable.smashfront,
			back = R.drawable.smashback,
			side = R.drawable.smashsuela,
		),
		ShoeModel(
			id = "4",
			name = "AIR JORDAN 1 RETRO",
			image = R.drawable.aj1retro,
			description = "",
			fav = false,
			price = 169.99,
			front = R.drawable.aj1front,
			back = R.drawable.aj1back,
			side = R.drawable.aj1suela,
		),
		ShoeModel(
			id = "5",
			name = "NEW BALANCE 550",
			image = R.drawable.newbalance,
			description = "",
			fav = false,
			price = 150.00,
			front = R.drawable.newbalancefront,
			back = R.drawable.newbba,
			side = R.drawable.newbalancesuela,
		),
		ShoeModel(
			id = "6",
			name = "Stan Smith",
			image = R.drawable.stansmith,
			description = "",
			fav = false,
			price = 150.00,
			front = R.drawable.stansmithfront,
			back = R.drawable.stansmith,
			side = R.drawable.stansmithsuela,
		)
	)
}