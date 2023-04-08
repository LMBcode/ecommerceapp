package com.example.myecommerceapp

import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot

sealed class ItemResponse{
    data class OnSuccess(val querySnapshot: QuerySnapshot?) : ItemResponse()
    data class OnError(val exception: FirebaseFirestoreException?) : ItemResponse()
}
