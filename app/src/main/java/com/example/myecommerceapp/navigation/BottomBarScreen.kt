package com.example.myecommerceapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(val route : String,val title:String,val icon:ImageVector){
    object Home : BottomBarScreen("home","home", Icons.Default.Home)
    object Favorite : BottomBarScreen("favorite","favourite",Icons.Default.Favorite)
    object ShoppingCart : BottomBarScreen("shopping_cart","Cart",Icons.Default.ShoppingCart)
    object SearchScreen : BottomBarScreen("search","search",Icons.Default.Search)
}
