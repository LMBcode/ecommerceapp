package com.example.myecommerceapp.screens.cartscreen

import android.icu.text.CaseMap.Title
import android.util.Log
import android.widget.Toast
import com.example.myecommerceapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myecommerceapp.domain.model.CartItem
import com.example.myecommerceapp.navigation.BottomBarScreen
import com.example.myecommerceapp.navigation.EcommerceDestinations
import com.example.myecommerceapp.presentation.viewmodel.CalculateViewModel
import com.example.myecommerceapp.presentation.viewmodel.CartViewModel

@Composable
fun ShoppingCart(
    viewModel: CartViewModel = hiltViewModel(),
    mviewModel: CalculateViewModel = hiltViewModel(),
    navController: NavController
) {
    val context = LocalContext.current
    val openDialog = remember { mutableStateOf(false) }
    val state = viewModel.state.value
    val configuration = LocalConfiguration.current
    mviewModel.totalPrice(state.items)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            Row() {
                Text(
                    text = "CART",
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f),
                    style = MaterialTheme.typography.subtitle2
                )
                Text(
                    text = "TOTAL = €" + mviewModel._totalPrice.value.toString(),
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        Log.d("ScreenHeight", configuration.screenHeightDp.dp.toString())
        items(state.items) { item ->
            CartItem(item = item)
        }
        item {
            Button(
                onClick = { openDialog.value = true }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = "CHECKOUT")
            }
        }
    }
    if (openDialog.value) {
        AlertDialog(onDismissRequest = { openDialog.value = false },
            text = {
                Text(
                    "Confirm Purchase",
                    color = MaterialTheme.colors.primary
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        Toast.makeText(context,"THANKS FOR YOUR PURCHASE",Toast.LENGTH_LONG).show()
                        (navController.navigate(BottomBarScreen.Home.route))
                              viewModel.deleteAll()},
                ) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                Button(onClick = { openDialog.value = false }) {
                    Text(text = "Cancel")
                }
            }
        )
    }
    Log.d("TotalPrice", mviewModel._totalPrice.value.toString())
}


@Composable
fun CartItem(item: CartItem?, myviewModel: CartViewModel = hiltViewModel()) {
    val viewModel: CalculateViewModel =
        viewModel(LocalContext.current as ViewModelStoreOwner, key = item!!.name)


    if (viewModel._quantity.value < 1) viewModel._quantity.value = 1
    Column(modifier = Modifier.padding(6.dp)) {
        Divider(color = Color.Gray, thickness = 1.dp)

        Row() {
            Text(
                text = item.brand!!,
                modifier = Modifier
                    .padding(start = 10.dp, top = 8.dp)
                    .weight(1f),
                style = MaterialTheme.typography.h3
            )
            IconButton(onClick = { myviewModel.removeItem(item) }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }
        }
        Text(
            text = item.name!!,
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(start = 10.dp)
        )
        Row() {
            Image(
                painter = painterResource(id = item.image!!),
                contentDescription = null,
                modifier = Modifier.size(100.dp),
            )
            Column(modifier = Modifier.padding(top = 62.dp)) {
                Text(
                    text = "Size ${item.size}",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }
        Row(modifier = Modifier.padding(6.dp)) {
            Row(
                modifier = Modifier
                    .padding(6.dp)
                    .weight(1f)
            ) {
                Text(text = "Qty", Modifier.padding(top = 8.dp))
                IconButton(onClick = {
                    viewModel._quantity.value--
                    viewModel.calculatePrice(viewModel._quantity.value, item.price!!.toBigDecimal())
                    myviewModel.updateItem(
                        CartItem(
                            name = item.name,
                            id = item.id,
                            image = item.image,
                            price = item.price,
                            size = item.size,
                            brand = item.brand,
                            quantity = viewModel._quantity.value,
                            totalPrice = viewModel._price.value.toString()
                        )
                    )
                    Log.d(
                        "Shop",
                        "$viewModel._quantity.value ${viewModel._price.value}"
                    )
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.minus),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Text(text = viewModel._quantity.value.toString(), Modifier.padding(top = 6.dp))

                IconButton(onClick = {
                    viewModel._quantity.value++
                    viewModel.calculatePrice(viewModel._quantity.value, item.price!!.toBigDecimal())
                    myviewModel.updateItem(
                        CartItem(
                            name = item.name,
                            id = item.id,
                            image = item.image,
                            price = item.price,
                            size = item.size,
                            brand = item.brand,
                            quantity = viewModel._quantity.value,
                            totalPrice = viewModel._price.value.toString()
                        )
                    )
                    Log.d(
                        "Shop",
                        "$viewModel._quantity.value ${viewModel._price.value}"
                    )
                }) {
                    Icon(imageVector = Icons.Default.AddCircle, contentDescription = null)
                }

            }
            Row(modifier = Modifier.padding(6.dp)) {
                Text(
                    text = "€" + viewModel._price.value.toString(),
                    style = MaterialTheme.typography.h6
                )
            }

        }
        Divider(color = Color.Gray, thickness = 1.dp)
        if (viewModel._price.value < "0.00".toBigDecimal()) {
            viewModel._price.value = item.price!!.toBigDecimal()
        }
        if (viewModel._quantity.value == 1) {
            viewModel._price.value = item.price!!.toBigDecimal()
            viewModel._totalPrice.value = item.price!!.toBigDecimal()
        }
    }

}




