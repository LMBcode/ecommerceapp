package com.example.myecommerceapp.data.database.room.FavoriteDB

import com.example.myecommerceapp.data.database.room.FavoriteDB.ShoeDao
import com.example.myecommerceapp.data.database.room.FavoriteDB.ShoeRepository
import com.example.myecommerceapp.domain.model.Shoe
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShoeRepositoryImpl @Inject constructor(private val shoeDao: ShoeDao) : ShoeRepository {

    override fun getShoes(): Flow<List<Shoe>> {
        return shoeDao.getAll()
    }

    override suspend fun insertShoe(shoe: Shoe) {
        shoeDao.insertShoe(shoe)
    }

    override suspend fun deleteShoe(shoe: Shoe) {
        shoeDao.deleteShoe(shoe)
    }

    override suspend fun getShoe(id: Int) : Shoe?{
        return shoeDao.getShoe(id)
    }


}