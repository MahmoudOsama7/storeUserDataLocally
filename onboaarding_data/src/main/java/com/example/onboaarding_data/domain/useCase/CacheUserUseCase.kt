package com.example.onboaarding_data.domain.useCase

import com.example.onboaarding_data.data.mapper.toUserEntity
import com.example.onboaarding_data.data.remote.data.User
import com.example.onboaarding_data.domain.repository.OnBoardingDataRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CacheUserUseCase @Inject constructor(
    private val repository: OnBoardingDataRepository
) {
    suspend operator fun invoke(user: User) =repository.cacheUser(
        userEntity = user.toUserEntity()
    )
}