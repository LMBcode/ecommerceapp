package com.example.myecommerceapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myecommerceapp.ItemResponse
import com.example.myecommerceapp.ViewModel.Resource
import com.example.myecommerceapp.model.ShoeModel
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirebaseFirestoreVM @Inject constructor(private val repo: FirestoreRepo) : ViewModel()  {

    val isFavorite : MutableState<Boolean> = mutableStateOf(false)
     val shoesStateFlow = MutableStateFlow<ItemResponse?>(null)

    init{
        viewModelScope.launch {
            repo.getShoeFromDatabase().collect{
                shoesStateFlow.value = it
            }
        }
    }

    fun addToDatabase(shoe: ShoeModel)  {
        repo.addToDatabase(shoe)
    }
    fun deleteFromDatabase(shoe : ShoeModel) {
        repo.deleteFromDatabase(shoe)
    }
}