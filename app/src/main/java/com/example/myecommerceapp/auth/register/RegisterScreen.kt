package com.example.myecommerceapp.auth.register

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myecommerceapp.viewmodel.FirebaseViewModel
import com.example.myecommerceapp.viewmodel.Resource
import com.example.myecommerceapp.navigation.EcommerceDestinations
import com.example.myecommerceapp.ui.Appbar
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RegisterScreen(modifier: Modifier = Modifier,navController: NavController,viewModel: FirebaseViewModel = hiltViewModel()){
    var name by remember{ mutableStateOf("")}
    var email by remember{ mutableStateOf("")}
    var password by remember{ mutableStateOf("")}
    val coroutinesCope  = rememberCoroutineScope()
    var isError by rememberSaveable { mutableStateOf(false) }


    Scaffold(topBar = { Appbar()}) {

        Column(modifier = modifier
            .padding(top = 18.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "SIGN UP HERE !", style = MaterialTheme.typography.h2)
        }


        Column(modifier = modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            OutlinedTextField(
                value = name,
                onValueChange = {name = it},
                label =  { Text(text = "Name")},
                modifier = modifier
                    .padding(8.dp)
                    .fillMaxWidth())

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    isError = false },
                singleLine = true,
                isError = isError,
                label =  { Text(text = "Email")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = modifier
                    .padding(8.dp)
                    .fillMaxWidth())



            OutlinedTextField(
                value = password,
                onValueChange = {password = it},
                label =  { Text(text = "Password")},
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = modifier
                    .padding(8.dp)
                    .fillMaxWidth())
            
            Button(onClick = {
                coroutinesCope.launch {
                        viewModel.signUp(email,password).collect{
                            when(it){
                                is Resource.Loading -> {
                                    Log.d("TAG","LOADING")
                                }
                                is Resource.Success<*> -> {
                                    Log.d("TAG", "SUCCESS")
                                    navController.navigate(EcommerceDestinations.HomeScreen.route)
                                }
                                is Resource.Error<*> ->
                                    Log.d("TAG","ERROR")

                                else -> {
                                    Log.d("TAG","NOT WORKING")
                                }
                            }
                        }

                }
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 8.dp)


            ) {
                Text(text = "SIGN UP", modifier = modifier.fillMaxWidth())
            }


        }
    }




}