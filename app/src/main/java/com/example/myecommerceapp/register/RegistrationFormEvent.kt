package com.example.myecommerceapp.register

sealed class RegistrationFormEvent{
        data class EmailChanged(val email: String) : RegistrationFormEvent()
        data class PasswordChanged(val password: String) : RegistrationFormEvent()
        object Submit: RegistrationFormEvent()
}
