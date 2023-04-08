package com.example.myecommerceapp.screens.homeScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myecommerceapp.R
import com.example.myecommerceapp.data.database.room.usecase.ShoeEvent
import com.example.myecommerceapp.domain.model.Shoe
import com.example.myecommerceapp.domain.model.ShoeProvider
import com.example.myecommerceapp.domain.model.categories.CategoriesObject
import com.example.myecommerceapp.navigation.BottomBarScreen
import com.example.myecommerceapp.navigation.EcommerceDestinations
import com.example.myecommerceapp.presentation.viewmodel.ShoeDBViewModel


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val shoeList = ShoeProvider.getShoes()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    )
    {

        item { Banner() }

        item { CategoriesList(navController) }

        item { Features(text = "SHOP") }

            gridItems(
                data = shoeList,
                columnCount = 2,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier.padding(horizontal = 16.dp)
            ) { itemData ->
                ShoeItem(shoe = itemData, navController)
            }
    }

}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Favorite,
        BottomBarScreen.ShoppingCart,
        BottomBarScreen.SearchScreen
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )

        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavController
) {
    if (currentDestination != null) {
        BottomNavigationItem(
            label = {
                Text(text = screen.title)
            },
            icon = {
                Icon(
                    imageVector = screen.icon,
                    contentDescription = "Nav Icon"
                )
            },
            selected = currentDestination.hierarchy.any {
                it.route == screen.route
            },
            onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            },
            unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled)
        )
    }

}





@Composable
fun Banner(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .size(200.dp),
        elevation = 15.dp,
        shape = RoundedCornerShape(6.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.banner1),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun CategoriesList(navController: NavController) {
    val categoriesList = CategoriesObject.getCategories()
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(40.dp),
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        items(categoriesList) { categorie ->
            Categories(categories = categorie, navController)

        }
    }

}

@Composable
fun Categories(categories: Shoe, navController: NavController) {
    Column {
        Card(
            modifier = Modifier
                .width(60.dp)
                .padding(start = 8.dp, top = 16.dp)
                .height(50.dp),
            shape = CircleShape,
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Icon(painter = painterResource(id = categories.shoeLogo!!), contentDescription = null,
                modifier = Modifier
                    .clickable {
                        navController.navigate(
                            EcommerceDestinations.CategoryScreen.passToCategoryScreen(
                                categories.shoeBrand,
                                categories.shoeLogo
                            )
                        )
                    })
        }

        Text(
            text = categories.shoeBrand!!, color = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp),
            fontSize = 10.sp, textAlign = TextAlign.Center
        )
    }

}

@Composable
fun Features(text: String) {
    Row(
        modifier = Modifier
            .padding(16.dp)
    ) {

        Text(
            text = text,
            color = MaterialTheme.colors.primary,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.subtitle1, fontSize = 18.sp
        )
    }
}

@Composable
fun ShoeItem(
    shoe: Shoe,
    navController: NavController,
    viewModel: ShoeDBViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            Card(
                modifier = Modifier
                    .size(175.dp),
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp)
            ) {
                shoe.shoeImage?.let { painterResource(id = it) }?.let {
                    Image(
                        painter = it,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(
                                    EcommerceDestinations.DetailScreen.passToDetailScreen(
                                        shoe.id,
                                        shoe.shoeName,
                                        shoe.shoeImage,
                                        shoe.shoePrice,
                                        shoe.shoeFrontSide,
                                        shoe.shoeBackSide,
                                        shoe.shoeSide,
                                        shoe.shoeBrand,
                                        shoe.quantity
                                    )
                                )
                            },
                        contentScale = ContentScale.Crop
                    )
                }
            }
            FavoriteButton(shoe = shoe)

        }

        shoe.shoeName?.let {
            Text(
                text = it,
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.paddingFromBaseline(12.dp, 12.dp)
            )
        }

        Text(
            text = shoe.shoePrice + "€",
            color = MaterialTheme.colors.primary,
            modifier = Modifier.paddingFromBaseline(12.dp, 8.dp)
        )
    }
}

val shoeMap = mutableMapOf<String,MutableState<Shoe>>()


@SuppressLint("UnrememberedMutableState")
@Composable
fun FavoriteButton(shoe: Shoe) {

    val viewModel : ShoeDBViewModel = viewModel()

    if (!shoeMap.containsKey(shoe.id.toString())){
        val a : MutableState<Shoe> = mutableStateOf(shoe)
        shoeMap[shoe.id.toString()] = a
    }

    IconToggleButton(
        checked = shoeMap[shoe.id.toString()]!!.value.isFavorite,
        onCheckedChange = {
            shoeMap[shoe.id.toString()]!!.value = Shoe(isFavorite = it)
        }
    ) {
        Icon(
            imageVector = if (shoeMap[shoe.id.toString()]!!.value.isFavorite){
                Icons.Rounded.Favorite
            } else {
                Icons.Rounded.FavoriteBorder
            }, contentDescription = null, tint = Color.Red
        )
    }
    if (shoeMap[shoe.id.toString()]!!.value.isFavorite){
        viewModel.onEvent(ShoeEvent.InsertNote(shoe))
    }else{
        viewModel.onEvent(ShoeEvent.DeleteNote(shoe))
    }

}



fun <T> LazyListScope.gridItems(
    data: List<T>,
    columnCount: Int,
    modifier: Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    itemContent: @Composable BoxScope.(T) -> Unit,
) {
    val size = data.count()
    val rows = if (size == 0) 0 else 1 + (size - 1) / columnCount
    items(rows, key = { it.hashCode() }) { rowIndex ->
        Row(
            horizontalArrangement = horizontalArrangement,
            modifier = modifier
        ) {
            for (columnIndex in 0 until columnCount) {
                val itemIndex = rowIndex * columnCount + columnIndex
                if (itemIndex < size) {
                    Box(
                        modifier = Modifier.weight(1F, fill = true),
                        propagateMinConstraints = true
                    ) {
                        itemContent(data[itemIndex])
                    }
                } else {
                    Spacer(Modifier.weight(1F, fill = true))
                }
            }
        }
    }
}
