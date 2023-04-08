package com.example.myecommerceapp.screens.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myecommerceapp.presentation.viewmodel.SearchViewModel
import com.example.myecommerceapp.screens.homeScreen.ShoeItem
import com.example.myecommerceapp.screens.homeScreen.gridItems

@Composable
fun SearchScreen(modifier : Modifier = Modifier, viewModel: SearchViewModel = viewModel(),navController: NavController){

    val shoeList = viewModel.search.observeAsState().value

    LazyColumn(modifier = Modifier) {

        item { SearchBar() }

        if (!shoeList.isNullOrEmpty()) {
            gridItems(
                data = shoeList,
                columnCount = 2,
                modifier = modifier.padding(18.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){ itemData ->
                ShoeItem(shoe = itemData, navController = navController)
            }

        }
    }
}
@Composable
fun SearchBar(modifier: Modifier = Modifier, viewModel: SearchViewModel = viewModel()) {

    var query: String by rememberSaveable { mutableStateOf("") }
    var showClearIcon by rememberSaveable { mutableStateOf(false) }

    if (query.isEmpty()) {
        showClearIcon = false
    } else if (query.isNotEmpty()) {
        showClearIcon = true
    }

    OutlinedTextField(
        value = query,
        onValueChange = { onQueryChanged ->
            query = onQueryChanged
            if (onQueryChanged.isNotEmpty()) {
                viewModel.performQuery(onQueryChanged)
            }
        },
        modifier = modifier
            .heightIn(56.dp)
            .fillMaxWidth(),
        label = { Text(text = "What are you looking for?", color = Color.Gray, fontSize = 18.sp) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color.Black
            )
        },
        trailingIcon = {
            if (showClearIcon) {
                IconButton(onClick = { query = "" }) {
                    Icon(
                        imageVector = Icons.Rounded.Clear,
                        tint = MaterialTheme.colors.onBackground,
                        contentDescription = "Clear Icon"
                    )
                }
            }
        },
        colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.background),
        shape = RoundedCornerShape(16.dp)
    )
}
