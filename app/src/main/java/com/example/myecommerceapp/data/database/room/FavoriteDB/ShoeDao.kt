package com.example.myecommerceapp.data.database.room.FavoriteDB

import androidx.room.*
import com.example.myecommerceapp.domain.model.Shoe
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoeDao {
    @Query("SELECT * FROM shoe")
    fun getAll() : Flow<List<Shoe>>

    @Query("SELECT * FROM shoe WHERE id = :id ")
    suspend fun getShoe(id : Int) : Shoe?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoe(shoe: Shoe)

    @Delete
    fun deleteShoe(shoe: Shoe)





}