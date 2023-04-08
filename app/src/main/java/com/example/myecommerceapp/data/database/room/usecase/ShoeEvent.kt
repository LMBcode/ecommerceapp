package com.example.myecommerceapp.data.database.room.usecase

import com.example.myecommerceapp.domain.model.Shoe
import com.example.myecommerceapp.domain.utils.ShoeOrder

sealed class ShoeEvent{

    data class InsertNote(val shoe: Shoe) : ShoeEvent()
    data class DeleteNote(val shoe: Shoe) : ShoeEvent()

}
