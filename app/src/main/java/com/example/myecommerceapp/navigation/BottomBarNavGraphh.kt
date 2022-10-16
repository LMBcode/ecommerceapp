package com.example.myecommerceapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myecommerceapp.screens.favoritescreen.FavoriteScreen
import com.example.myecommerceapp.screens.homeScreen.HomeScreen
import com.example.myecommerceapp.screens.profilescreen.ProfileScreen

@Composable
fun BottomBarNavGraph(navController: NavHostController){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route){
        composable(BottomBarScreen.Home.route){
            HomeScreen(navController = navController)
        }
        composable(BottomBarScreen.Profile.route){
           ProfileScreen()
        }
        composable(BottomBarScreen.Favorite.route){
            FavoriteScreen(navController = navController)
        }
    }


}