package com.example.myecommerceapp.data.database.room.usecase

import com.example.myecommerceapp.data.database.room.FavoriteDB.ShoeRepository
import com.example.myecommerceapp.domain.model.Shoe
import kotlinx.coroutines.flow.Flow

class GetShoes (private val repository: ShoeRepository) {

    operator fun invoke(): Flow<List<Shoe>> {
        return repository.getShoes()
    }
}
