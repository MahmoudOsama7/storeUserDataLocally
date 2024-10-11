package com.example.onboarding.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.onboarding.ui.screens.OnBoardingScreen
import com.example.onboarding.ui.screens.OnBoardingViewModel

const val ON_BOARDING = "onBoarding"

fun NavHostController.navigateToOnBoardingScreen() {
    this.navigate(ON_BOARDING)
}


fun NavGraphBuilder.onBoardingNavigation(
    navigateToGatheredInformationScreen:()->Unit
) {
    composable(ON_BOARDING) {
        val viewModel:OnBoardingViewModel= hiltViewModel()
        OnBoardingScreen(
            viewModel=viewModel,
            onContinueClicked=navigateToGatheredInformationScreen
        )
    }
}