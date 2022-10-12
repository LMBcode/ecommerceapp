package com.example.myecommerceapp.usecase

import android.util.Patterns

class ValidateEmail {
    fun execute(email : String) :ValidationResult{
        if(email.isBlank()){
            return ValidationResult(
                false,
                "The email cannot be blank"
            )
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return ValidationResult(
                false,
                "The email is not valid"
            )
        }
        return ValidationResult(successful = true)
    }

}