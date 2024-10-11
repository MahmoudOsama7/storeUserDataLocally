package com.example.gatherdInformation.model

import com.example.onboaarding_data.data.remote.data.User

data class GatheredInformationViewState(
    val users:List<User> = listOf()
)