package com.example.myecommerceapp.f.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myecommerceapp.f.ui.home.shoe.ShoeDisplay
import com.example.myecommerceapp.f.ui.util.activityViewModel

private const val activityOwned: Boolean = true
private const val hiltOwned: Boolean = true


// NavController is kinda redundant,
// we can instead provide LocalNavigator object with CompositionLocal
// or just use lambda callback
@Composable
fun HomeScreen(
	modifier: Modifier = Modifier,
	navController: NavController,
) {
	ShoeDisplay(
		modifier = modifier,
		viewModel = localViewModel(),
		navController = navController
	)
}

@Composable
private inline fun <reified VM: ViewModel> localViewModel(): VM {
	return when {
		activityOwned -> activityViewModel()
		hiltOwned -> hiltViewModel()
		else -> viewModel()
	}
}