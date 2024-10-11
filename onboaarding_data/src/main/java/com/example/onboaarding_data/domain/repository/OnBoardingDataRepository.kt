package com.example.onboaarding_data.domain.repository

import com.example.onboaarding_data.data.local.data.UserEntity
import kotlinx.coroutines.flow.Flow

interface OnBoardingDataRepository {
    suspend fun cacheUser(userEntity: UserEntity)
    suspend fun getAllUsers(): Flow<List<UserEntity>>
}