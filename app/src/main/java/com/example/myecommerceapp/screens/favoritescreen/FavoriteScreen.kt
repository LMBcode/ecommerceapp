package com.example.myecommerceapp.screens.favoritescreen

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun FavoriteScreen(){
    Box(modifier = Modifier, contentAlignment = Alignment.Center){
        Text(text = "FAV")
    }
}