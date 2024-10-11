package com.example.gatherdInformation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.gatherdInformation.ui.screens.GatheredInformationScreen
import com.example.gatherdInformation.ui.screens.GatheredInformationViewModel

const val GATHERED_INFORMATION_SCREEN="gathered_information_screen"

fun NavHostController.navigateToGatheredInformationScreen() {
    this.navigate(GATHERED_INFORMATION_SCREEN)
}


fun NavGraphBuilder.gatheredInformationNavigation(
    onBackPressed:()->Unit
) {
    composable(GATHERED_INFORMATION_SCREEN) {
        val viewModel: GatheredInformationViewModel = hiltViewModel()
        GatheredInformationScreen(
            viewModel=viewModel,
            onBackPressed=onBackPressed
        )
    }
}