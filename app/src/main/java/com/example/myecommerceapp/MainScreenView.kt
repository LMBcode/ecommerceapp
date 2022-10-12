package com.example.myecommerceapp

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.myecommerceapp.navigation.BottomBarNavGraph
import com.example.myecommerceapp.screens.homeScreen.BottomBar
import com.example.myecommerceapp.ui.SetUpNavigation

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreenView(){
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomBar(navController) }
    ){
        SetUpNavigation(navController = navController)
    }
}