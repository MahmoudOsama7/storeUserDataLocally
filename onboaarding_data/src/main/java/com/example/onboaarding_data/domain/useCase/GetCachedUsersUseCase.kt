package com.example.onboaarding_data.domain.useCase

import com.example.onboaarding_data.data.mapper.toUser
import com.example.onboaarding_data.data.remote.data.User
import com.example.onboaarding_data.domain.repository.OnBoardingDataRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.first
import javax.inject.Inject

@ViewModelScoped
class GetCachedUsersUseCase @Inject constructor(
    private val repository: OnBoardingDataRepository
) {
    suspend operator fun invoke():List<User> =
        repository.getAllUsers().first().map { it.toUser() }
}