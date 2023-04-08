package com.example.myecommerceapp.screens.detailscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myecommerceapp.domain.model.shoe.AllShoesObject
import com.example.myecommerceapp.screens.homeScreen.ShoeItem
import com.example.myecommerceapp.screens.homeScreen.gridItems

@Composable
fun CategoryScreen(navController: NavController, name : String ?=null, logo : Int?){
    var shoeList = AllShoesObject.getShoes()
    when(name){
        "NIKE" -> shoeList = AllShoesObject.getNIKE()

        "ADIDAS" -> shoeList = AllShoesObject.getADIDAS()

        "PUMA" -> shoeList = AllShoesObject.getPUMA()

        "NEW BALANCE" -> shoeList = AllShoesObject.getNB()
    }
    LazyColumn(modifier = Modifier){
        item{
            Text(text = name.toString(), modifier = Modifier.padding(16.dp))
        }
        gridItems(
            data = shoeList,
            columnCount = 2,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
                data ->
            ShoeItem(shoe = data, navController = navController)
        }


    }





}