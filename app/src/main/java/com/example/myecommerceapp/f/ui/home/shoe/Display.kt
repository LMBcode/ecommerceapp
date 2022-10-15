package com.example.myecommerceapp.f.ui.home.shoe

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.res.ResourcesCompat
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.myecommerceapp.f.ui.home.HomeViewModel
import com.example.myecommerceapp.f.ui.util.activityViewModel
import com.example.myecommerceapp.navigation.EcommerceDestinations
import com.example.myecommerceapp.screens.homeScreen.*

private const val activityOwned: Boolean = false
private const val hiltOwned: Boolean = true

@Composable
fun ShoeDisplay(
	modifier: Modifier = Modifier,
	viewModel: HomeViewModel,
	navController: NavController
) {
	ShoeDisplayContents(
		modifier = modifier,
		shoeList = viewModel.observeShoeList().collectAsState(initial = emptyList()).value,
		navController = navController
	)
}

@Composable
private fun ShoeDisplayContents(
	modifier: Modifier = Modifier,
	shoeList: List<String>,
	navController: NavController
) {
	LazyColumn(
		modifier = Modifier
			.fillMaxSize()
			.then(modifier),
	) {

		item { SearchBar(modifier = modifier.padding(16.dp, vertical = 8.dp)) }

		item { Banner() }

		item { CategoriesList(navController) }

		item { Features(text = "TOP SHOES") }

		gridItems(
			data = shoeList,
			columnCount = 2,
			horizontalArrangement = Arrangement.spacedBy(8.dp),
			modifier = modifier.padding(horizontal = 16.dp)
		) { id ->
			ShoeDisplayItem(id = id, navController = navController)
		}
	}
}

@Composable
private fun ShoeDisplayItem(
	id: String,
	navController: NavController,
) {
	val vm: ShoeViewModel = localViewModel(id)
	val resId = vm.observeImageForId(id).collectAsState(initial = /* placeholder */ ResourcesCompat.ID_NULL)
	val fav = vm.observeFavForId(id).collectAsState(initial = false)
	val name = vm.observeNameForId(id).collectAsState(initial = "")
	val price = vm.observePriceForId(id).collectAsState(initial = 0.0)
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
				if (resId.value != ResourcesCompat.ID_NULL) {
					Image(
						painter = painterResource(id = resId.value),
						contentDescription = null,
						modifier = Modifier
							.fillMaxWidth()
							.clickable {
								// TODO: navigate by Id instead
								navController.navigate(
									EcommerceDestinations.DetailScreen.passNameAndImage(
										name = name.value,
										image = resId.value,
										price = price.value.toString(),
										shoeFrontSide = vm.getShoeFront(id),
										shoeBackSide = vm.getShoeBack(id),
										shoeSide = vm.getShoeSide(id)
									)
								)
							},
						contentScale = ContentScale.Crop
					)
				}
			}

			FavoriteButton(fav = fav.value, changeFav = { fav -> vm.changeFavForId(id, fav) })
		}

		Text(
			text = name.value,
			color = MaterialTheme.colors.primary,
			style = MaterialTheme.typography.caption,
			modifier = Modifier.paddingFromBaseline(12.dp,12.dp)
		)

		Text(
			text = price.value.toString() + "€",
			color = MaterialTheme.colors.primary,
			modifier = Modifier.paddingFromBaseline(12.dp,8.dp)
		)
	}
}

@Composable
fun FavoriteButton(fav: Boolean, changeFav: (Boolean) -> Unit) {
	IconToggleButton(
		checked = fav,
		onCheckedChange = changeFav
	) {
		Icon(
			imageVector = if (fav) {
				Icons.Filled.Favorite
			} else {
				Icons.Filled.FavoriteBorder
			},
			contentDescription = null,
			tint = MaterialTheme.colors.primary
		)
	}
}

@Composable
private inline fun <reified VM: ViewModel> localViewModel(key: String? = null): VM {
	return when {
		activityOwned -> activityViewModel(key)
		hiltOwned -> hiltViewModel(key = key)
		else -> viewModel()
	}
}

@Composable
private inline fun <reified VM: ViewModel> hiltViewModel(
	viewModelStoreOwner: ViewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
		"No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
	},
	key: String? = null
): VM {
	val factory = createHiltViewModelFactory(viewModelStoreOwner = viewModelStoreOwner)
	return viewModel(viewModelStoreOwner = viewModelStoreOwner, key = key, factory = factory)
}

@Composable
private fun createHiltViewModelFactory(
	viewModelStoreOwner: ViewModelStoreOwner
): ViewModelProvider.Factory? = if (viewModelStoreOwner is NavBackStackEntry) {
	HiltViewModelFactory(
		context = LocalContext.current,
		navBackStackEntry = viewModelStoreOwner
	)
} else {
	null
}