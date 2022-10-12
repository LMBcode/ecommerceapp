package com.example.myecommerceapp.usecase

data class ValidationResult(
    val successful : Boolean,
    val errorMessage : String ?= null
)
