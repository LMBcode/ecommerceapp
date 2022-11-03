package com.example.myecommerceapp.screens.favoritescreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myecommerceapp.domain.model.Shoe
import com.example.myecommerceapp.screens.homeScreen.ShoeItem
import com.example.myecommerceapp.screens.homeScreen.gridItems
import com.example.myecommerceapp.presentation.viewmodel.ShoeDBViewModel

@Composable
fun FavoriteScreen(navController: NavController, viewModel: ShoeDBViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    HomeContent(navController = navController, shoes = state.shoes)
}


@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    shoes: List<Shoe> = emptyList(),
    navController: NavController
) {
    LazyColumn {
        item { Text(text = "FAVORITE SHOES", modifier = modifier.padding(8.dp), style = MaterialTheme.typography.body2) }
        gridItems(
            data = shoes,
            columnCount = 2,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) { data ->
            ShoeItem(shoe = data, navController = navController)
        }
    }

}