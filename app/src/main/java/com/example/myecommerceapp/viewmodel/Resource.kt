package com.example.myecommerceapp.ViewModel

import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import java.lang.Exception

sealed class Resource<out T>
{


    data class Success<T>(val data: T?) : Resource<T>()
    data class Error<T>(val e: Exception) : Resource<T>()
    object Loading : Resource<Nothing>()
    class Unspecified<T> : Resource<T>()

}

