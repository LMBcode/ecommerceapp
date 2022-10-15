package com.example.myecommerceapp.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
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
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(modifier: Modifier = Modifier,navController: NavController){
    Scaffold(topBar = { Appbar() }) {
        Column(modifier = modifier
            .fillMaxSize()
            .padding(top = 45.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Welcome!",
                style = MaterialTheme.typography.h4,
            )
        }

        Column(modifier = modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center) {
            LoginEDT(navController = navController)
        }
    }
}

@Composable
fun Appbar(modifier: Modifier = Modifier){
    
        TopAppBar(title =
        {
            Row {
                Icon(Icons.Default.Home,contentDescription = null)
                Spacer(modifier = modifier.width(8.dp))
               Text(text = "LOGIN") 
            }
        })
}


@Composable
private fun LoginEDT(modifier: Modifier = Modifier,navController: NavController,viewModel: FirebaseViewModel = hiltViewModel()){
    val coroutineScope = rememberCoroutineScope()
    var email by remember{ mutableStateOf("")}
    var password by remember{ mutableStateOf("")}
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center
    ) {
           OutlinedTextField(value = email,
               onValueChange = {email = it},
           label = {Text("Username")},
           modifier = modifier
               .padding(8.dp)
               .fillMaxWidth())


        OutlinedTextField(value = password,
            onValueChange = {password = it},
            label = {Text("Password")},
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        Button(onClick = {
            coroutineScope.launch {
                viewModel.logIn(email, password).collect {
                    when (it) {
                        is Resource.Loading ->{
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
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(text = "SIGN IN", modifier = Modifier.fillMaxWidth())
        }
        
        TextButton(onClick = { navController.navigate(EcommerceDestinations.RegisterScreen.route) },
        modifier = modifier
            .padding(12.dp),
        ) {
            Text(text = "You don't have an account?\r\nRegister Here!")
        }

    }
}


@Composable
 fun TestScreen(navController: NavController, viewModel: FirebaseViewModel = hiltViewModel()){
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            Log.d("TAG","BUTTON CLICKED")
            viewModel.logOut()
            navController.navigate(EcommerceDestinations.LoginScreen.route)

        }) {
            Text(text = "LOGOUT")
        }
    }
}

