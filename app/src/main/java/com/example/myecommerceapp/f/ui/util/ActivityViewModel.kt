package com.example.myecommerceapp.f.ui.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel


/**
 * retrieve or create the specified ViewModel [VM] in Local Activity within current Composition
 *
 * @throws [IllegalArgumentException] if no Local [Activity] that implements [ViewModelStoreOwner]
 * is found within current Composition Context
 *
 * @return [ViewModel] owned by local [Activity]
 */
@Composable
@Throws(IllegalArgumentException::class)
public inline fun <reified VM: ViewModel> activityViewModel(key: String? = null): VM {

	val activity: Activity? = LocalContext.current.findActivity()

	requireNotNull(activity) {
		"activityViewModel must be called from within Activity composition Context"
	}

	return activityViewModel(activity, key)
}

/**
 * retrieve or create the specified ViewModel [VM] from given [activity]
 *
 * @throws [IllegalArgumentException] if [Activity] does Not implement [ViewModelStoreOwner]
 *
 * @return [ViewModel] owned by given [activity]
 */
@Composable
@Throws(IllegalArgumentException::class)
public inline fun <reified VM: ViewModel> activityViewModel(activity: Activity, key: String? = null): VM {

	require(activity is ViewModelStoreOwner) {
		"Activity does Not implement ViewModelStoreOwner"
	}

	// Delegate our call to androidx library
	return viewModel(activity, key)
}

fun Context.findActivity(): Activity? {
	var context: Context = this
	while (context is ContextWrapper) {
		if (context is Activity) return context
		context = context.baseContext
	}
	return null
}
