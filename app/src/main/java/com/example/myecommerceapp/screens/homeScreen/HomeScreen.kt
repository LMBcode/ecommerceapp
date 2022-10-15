package com.example.myecommerceapp.screens.homeScreen

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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myecommerceapp.R
import com.example.myecommerceapp.navigation.BottomBarScreen
import com.example.myecommerceapp.navigation.EcommerceDestinations
import com.example.myecommerceapp.model.categories.CategoriesModel
import com.example.myecommerceapp.model.categories.CategoriesObject
import com.example.myecommerceapp.model.ShoeModel
import com.example.myecommerceapp.model.ShoeObject
import com.example.myecommerceapp.viewmodel.FirebaseFirestoreVM


@Composable
fun HomeScreen(modifier: Modifier = Modifier , navController: NavController){
    val shoeList = ShoeObject.getShoes()
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
        )
        {

            item { SearchBar(modifier = modifier.padding(16.dp, vertical = 8.dp)) }

            item { Banner() }

            item { CategoriesList(navController) }

            item { Features(text = "TOP SHOES") }

            //item { ShoeRow(navController = navController) }

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
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Favorite,
        BottomBarScreen.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation() {
        screens.forEach { screen ->
            AddItem(screen = screen, currentDestination = currentDestination , navController = navController)

        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination : NavDestination?,
    navController: NavController
){
    if (currentDestination != null) {
        BottomNavigationItem(label = {
            Text(text = screen.title)
        },
            icon = {
                Icon(imageVector = screen.icon,
                    contentDescription = "Nav Icon")
            },
            selected = currentDestination.hierarchy.any{
                it.route == screen.route
            },
            onClick = {
                navController.navigate(screen.route){
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            },
            unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled)
        )
    }

}


/*@Composable
fun Header(modifier: Modifier = Modifier,text : String ){
        Text(
            text = text,
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.primary,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 16.dp)
        )
}*/


@Composable
fun SearchBar(modifier: Modifier = Modifier){
    OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = modifier
                .heightIn(56.dp)
                .fillMaxWidth(),
            label = { Text(text = "What are you looking for?", color = Color.Gray) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.Black
                )
            },
            colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.background),
            shape = RoundedCornerShape(16.dp)
    )
}

@Composable
fun Banner(modifier: Modifier = Modifier){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
            .size(200.dp),
        elevation = 15.dp,
        shape = RoundedCornerShape(8.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.nike_banner),
            contentDescription = null,
            contentScale = ContentScale.Crop)
    }
}

@Composable
fun CategoriesList(navController: NavController){
    val categoriesList = CategoriesObject.getCategories()
    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(bottom = 16.dp)){
        items(categoriesList){ categorie ->
            Categories(categories = categorie,navController)

        }
    }

}

@Composable
fun Categories(categories: CategoriesModel, navController: NavController){
    Column {
        Card(
            modifier = Modifier
                .width(60.dp)
                .padding(start = 8.dp, top = 16.dp)
                .height(50.dp)
                .clickable { navController.navigate(categories.navigate) },
            shape = CircleShape,
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Icon(painter = painterResource(id = categories.imgae), contentDescription = null)
        }

            Text(
                text = categories.name, color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp),
                fontSize = 10.sp, textAlign = TextAlign.Center
            )
    }

}

@Composable
fun Features(text: String){
    Row(modifier = Modifier
        .padding(16.dp)) {

        Text(text = text ,
            color = MaterialTheme.colors.primary,
            modifier = Modifier.
            weight(1f),
        style = MaterialTheme.typography.subtitle1, fontSize = 18.sp)
    }
}

@Composable
fun ShoeItem(shoe : ShoeModel,navController: NavController) {

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
                Image(
                    painter = painterResource(id = shoe.shoeImage),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(
                                EcommerceDestinations.DetailScreen.passNameAndImage(
                                    shoe.shoeName,
                                    shoe.shoeImage,
                                    shoe.shoePrice.toString(),
                                    shoe.shoeFrontSide,
                                    shoe.shoeBackSide,
                                    shoe.shoeSide
                                )
                            )
                        },
                    contentScale = ContentScale.Crop
                )
            }
            FavoriteButton(shoe = shoe)

        }

      Text(text = shoe.shoeName,color = MaterialTheme.colors.primary, style = MaterialTheme.typography.caption, modifier = Modifier.paddingFromBaseline(12.dp,12.dp))

      Text(text = shoe.shoePrice.toString() + "€",color = MaterialTheme.colors.primary,modifier = Modifier.paddingFromBaseline(12.dp,8.dp))
    }
}

@Composable
fun FavoriteButton(shoe : ShoeModel){


    val myviewModel : FirebaseFirestoreVM =
        viewModel(LocalContext.current as ViewModelStoreOwner, key = shoe.shoeName)


    

    IconToggleButton(
        checked = shoe.isFavorite,
        onCheckedChange = {
           shoe.isFavorite= !shoe.isFavorite
        }
    ) {
        Icon(
            imageVector = if (shoe.isFavorite ) {
                Icons.Filled.Favorite
            } else {
                Icons.Filled.FavoriteBorder
            }, contentDescription = null, tint = MaterialTheme.colors.primary
        )
    }
    if (shoe.isFavorite) {
        myviewModel.addToDatabase(shoe)
    }
}


/*@Composable
fun ShoeRow(navController: NavController){
    val shoeList = ShoeObject.getShoes()
    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp),modifier = Modifier.padding(top = 8.dp, start = 16.dp)){
        items(shoeList){shoe ->
            ShoeItem(shoe = shoe, navController = navController )
            
        }
    }
}*/

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
