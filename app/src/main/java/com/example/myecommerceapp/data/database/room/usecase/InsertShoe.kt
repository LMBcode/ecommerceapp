package com.example.myecommerceapp.data.database.room.usecase

import com.example.myecommerceapp.data.database.room.FavoriteDB.ShoeRepository
import com.example.myecommerceapp.domain.model.Shoe

class InsertShoe(private val shoeRepository: ShoeRepository) {

    suspend operator fun invoke(shoe: Shoe){
        shoeRepository.insertShoe(shoe)
    }
}
