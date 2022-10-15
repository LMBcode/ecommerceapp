package com.example.myecommerceapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myecommerceapp.ViewModel.Resource
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class FirebaseViewModel @Inject constructor(private val firebaseAuth: FirebaseAuth) : ViewModel() {


    fun logIn(email:String,password : String) = flow  {
        try{
            emit(Resource.Loading)
            val result = firebaseAuth.signInWithEmailAndPassword(email, password)
                .await()
            emit(Resource.Success(result))

        }
        catch (e:Exception){
            emit(Error(e))
        }
    }

    fun signUp(email:String,password: String) = flow{
        try{
            emit(Resource.Loading)
            val result = firebaseAuth.createUserWithEmailAndPassword(email,password)
                .await()
            emit(Resource.Success(result))
        }
        catch (e:Exception){
            emit(Error(e))
        }
    }

    fun logOut(){
        firebaseAuth.signOut()
    }





}