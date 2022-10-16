package com.example.myecommerceapp.screens.favoritescreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myecommerceapp.ItemResponse
import com.example.myecommerceapp.model.ShoeModel
import com.example.myecommerceapp.screens.homeScreen.ShoeItem
import com.example.myecommerceapp.viewmodel.FirebaseFirestoreVM
import kotlinx.coroutines.flow.asStateFlow

@Composable
fun FavoriteScreen(viewModel: FirebaseFirestoreVM = hiltViewModel(),navController: NavController){

        when(val shoeList = viewModel.shoesStateFlow.asStateFlow().collectAsState().value){
            is ItemResponse.OnError -> {
                Text(text = "Error")
            }
            is ItemResponse.OnSuccess -> {
                val listOfShoes= shoeList.querySnapshot?.toObjects(ShoeModel::class.java)
                listOfShoes?.let {
                    LazyColumn(modifier = Modifier
                        .padding(16.dp)
                        .fillMaxHeight()){
                        items(listOfShoes){
                            ShoeItem(it , navController = navController )
                        }
                    }
                }
            }
            else -> {}
        }
}