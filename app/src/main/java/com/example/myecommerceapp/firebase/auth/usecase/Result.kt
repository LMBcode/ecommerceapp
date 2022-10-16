package com.example.myecommerceapp.firebase.auth.usecase

data class ValidationResult(
    val successful : Boolean,
    val errorMessage : String ?= null
)
