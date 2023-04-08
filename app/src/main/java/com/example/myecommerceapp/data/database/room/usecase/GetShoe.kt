package com.example.myecommerceapp.data.database.room.usecase

import com.example.myecommerceapp.data.database.room.FavoriteDB.ShoeRepository
import com.example.myecommerceapp.domain.model.Shoe

class GetShoe(private val repository: ShoeRepository) {

    suspend operator fun invoke(id: Int): Shoe? {
        return repository.getShoe(id)
    }


}