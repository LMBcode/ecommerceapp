package com.example.myecommerceapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.myecommerceapp.R
import com.example.myecommerceapp.navigation.BottomBarScreen
import com.example.myecommerceapp.navigation.EcommerceDestinations
import com.example.myecommerceapp.ui.theme.MyecommerceappTheme


@Composable
fun SplashScreen(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lf30_editor_vmnejmul))
        val logoAnimationState =
            animateLottieCompositionAsState(composition = composition)
        LottieAnimation(
            composition = composition,
            progress = { logoAnimationState.progress },
            modifier = Modifier
                .align(Alignment.Center),
            contentScale = ContentScale.Crop,
        )
        if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
            navController.navigate(BottomBarScreen.Home.route)
        }
    }

}

@Preview
@Composable
fun SplashScreenPreview(){
    MyecommerceappTheme() {
        SplashScreen(navController = rememberNavController())
    }
}