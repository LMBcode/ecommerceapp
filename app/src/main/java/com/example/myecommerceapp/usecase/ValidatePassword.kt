package com.example.myecommerceapp.usecase

import android.util.Patterns

class ValidatePassword {
    fun execute(password : String) :ValidationResult{
        if(password.isBlank()){
            return ValidationResult(
                false,
                "The password cannot be blank"
            )
        }

        if(password.length < 8){
            return ValidationResult(
                false,
                "Password needs to have at least 8 characters"
            )
        }


        val containsLettersAndDigits = password.any { it.isDigit() } && password.any{it.isLetter()}
        if (!containsLettersAndDigits )
        return ValidationResult(
            successful = false,
            "Password needs to contain at least one letter and one digit"
        )

        return ValidationResult(true)
    }

}