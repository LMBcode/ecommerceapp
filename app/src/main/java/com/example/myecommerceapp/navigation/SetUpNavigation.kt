package com.example.myecommerceapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myecommerceapp.*
import com.example.myecommerceapp.navigation.*
import com.example.myecommerceapp.screens.detailscreen.ShoeDetailScreen
import com.example.myecommerceapp.screens.homeScreen.HomeScreen
import com.example.myecommerceapp.register.RegisterScreen
import com.example.myecommerceapp.screens.favoritescreen.FavoriteScreen
import com.example.myecommerceapp.screens.profilescreen.ProfileScreen

@Composable
fun SetUpNavigation(navController: NavHostController){
    NavHost(navController, startDestination = EcommerceDestinations.SplashScreen.route) {
        composable(route = EcommerceDestinations.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = EcommerceDestinations.DetailScreen.route, listOf(
            navArgument(SHOE_NAME){
                type = NavType.StringType
            },
            navArgument(SHOE_IMAGE){
                type = NavType.IntType
            },
            navArgument(SHOE_PRICE){
                type = NavType.StringType
            },
            navArgument(SHOE_FRONT){
                type = NavType.IntType
            },
            navArgument(SHOE_BACK){
                type = NavType.IntType
            },
            navArgument(SHOE_SIDE){
                type = NavType.IntType
            }
        ))  { entry ->
            ShoeDetailScreen(navController = navController, name = entry.arguments?.getString(
                SHOE_NAME), image = entry.arguments?.getInt(SHOE_IMAGE), price = entry.arguments?.getString(
                SHOE_PRICE), frontSide = entry.arguments?.getInt(SHOE_FRONT), backside = entry.arguments?.getInt(
                SHOE_BACK),shoeside = entry.arguments?.getInt(
                SHOE_SIDE))
        }
        
        composable(route = BottomBarScreen.Home.route){ HomeScreen(navController = navController)}
        
        composable(route = EcommerceDestinations.SplashScreen.route){ SplashScreen(navController = navController)}
        
        composable(route = EcommerceDestinations.RegisterScreen.route) { RegisterScreen (navController = navController)}
        composable(BottomBarScreen.Profile.route){
            ProfileScreen()
        }
        composable(BottomBarScreen.Favorite.route){
            FavoriteScreen()
        }

    }
}