package com.example.myecommerceapp.data.database.room.usecase

import com.example.myecommerceapp.data.database.room.FavoriteDB.ShoeRepository
import com.example.myecommerceapp.domain.model.Shoe

class DeleteShoe(private val repository: ShoeRepository) {

    suspend operator fun invoke (shoe : Shoe){
        repository.deleteShoe(shoe)
    }
}
