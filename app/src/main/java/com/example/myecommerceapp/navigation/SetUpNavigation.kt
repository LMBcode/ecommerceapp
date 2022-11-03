package com.example.myecommerceapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myecommerceapp.navigation.*
import com.example.myecommerceapp.screens.detailscreen.ShoeDetailScreen
import com.example.myecommerceapp.screens.homeScreen.HomeScreen
import com.example.myecommerceapp.screens.cartscreen.ShoppingCart
import com.example.myecommerceapp.screens.detailscreen.CategoryScreen
import com.example.myecommerceapp.screens.favoritescreen.FavoriteScreen
import com.example.myecommerceapp.screens.profilescreen.ProfileScreen
import com.example.myecommerceapp.screens.search.SearchScreen

@Composable
fun SetUpNavigation(navController: NavHostController){
    NavHost(navController, startDestination = EcommerceDestinations.SplashScreen.route) {
        composable(route = EcommerceDestinations.DetailScreen.route, listOf(
            navArgument(SHOE_ID){
                type = NavType.IntType
            },
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
            },
            navArgument(SHOE_BRAND){
                type = NavType.StringType
            }
        ))  { entry ->
            ShoeDetailScreen(navController = navController, id= entry.arguments?.getInt(SHOE_ID), name = entry.arguments?.getString(
                SHOE_NAME), image = entry.arguments?.getInt(SHOE_IMAGE), price = entry.arguments?.getString(
                SHOE_PRICE), frontSide = entry.arguments?.getInt(SHOE_FRONT), backside = entry.arguments?.getInt(
                SHOE_BACK),shoeside = entry.arguments?.getInt(
                SHOE_SIDE), brand = entry.arguments?.getString(SHOE_BRAND))
        }

        composable(route = EcommerceDestinations.CategoryScreen.route, listOf(
            navArgument(SHOE_BRAND){
                type = NavType.StringType
            },
            navArgument(SHOE_LOGO){
                type = NavType.IntType
            }

        ))  { entry ->
            CategoryScreen(navController,
                  name = entry.arguments?.getString(
                    SHOE_BRAND), logo = entry.arguments?.getInt(SHOE_LOGO)
            )
        }

        composable(route = BottomBarScreen.ShoppingCart.route){ ShoppingCart()}
        
        composable(route = BottomBarScreen.Home.route){ HomeScreen(navController = navController)}
        
        composable(route = BottomBarScreen.SearchScreen.route){ SearchScreen(navController = navController)}
        
        composable(route = EcommerceDestinations.SplashScreen.route){ SplashScreen(navController = navController)}

        composable(BottomBarScreen.Favorite.route){
            FavoriteScreen(navController = navController)
        }

    }
}