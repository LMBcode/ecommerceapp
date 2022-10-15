package com.example.myecommerceapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myecommerceapp.model.ShoeModel
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirebaseFirestoreVM @Inject constructor(private val db: FirebaseFirestore) : ViewModel()  {


    val isFavorite : MutableState<Boolean> = mutableStateOf(false)

    fun addToDatabase(shoe : ShoeModel){
        val obj = ShoeModel(
            shoe.shoeName,
            shoe.shoeImage,
            shoe.shoeDescription,
            shoe.shoePrice,
            shoe.shoeFrontSide,
            shoe.shoeBackSide,
            shoe.shoeSide,
            shoe.isFavorite
        )
        db.collection("shoes").document(shoe.shoeName).set(obj)
    }

    fun deleteFromDatabase(shoe : ShoeModel){
        db.collection("shoes").document(shoe.shoeName)
            .delete()
    }

}