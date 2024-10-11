package com.example.onboarding.model

import com.example.onboaarding_data.data.remote.data.User

data class OnBoardingViewState(
    val user: User = User(),
    val buttonIsEnabled:Boolean=false
)