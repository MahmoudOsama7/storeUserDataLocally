package com.example.madarsofttask.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.gatherdInformation.navigation.gatheredInformationNavigation
import com.example.gatherdInformation.navigation.navigateToGatheredInformationScreen
import com.example.onboarding.navigation.ON_BOARDING
import com.example.onboarding.navigation.onBoardingNavigation

const val MAIN_ROUTE="MAIN"


@Composable
fun MainNavigation(){
    val navController= rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MAIN_ROUTE
    ){
        navigation(
            startDestination = ON_BOARDING,
            route = MAIN_ROUTE
        ){
            onBoardingNavigation(
                navigateToGatheredInformationScreen = {navController.navigateToGatheredInformationScreen()}
            )
            gatheredInformationNavigation(
                onBackPressed = {navController.navigateUp()}
            )
        }
    }
}