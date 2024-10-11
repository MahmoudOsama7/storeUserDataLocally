package com.example.onboaarding_data.data.repository

import com.example.onboaarding_data.data.local.data.UserEntity
import com.example.onboaarding_data.data.local.db.AppDao
import com.example.onboaarding_data.domain.repository.OnBoardingDataRepository
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@ActivityRetainedScoped
class OnBoardingDataRepositoryImpl @Inject constructor(
    private val appDao: AppDao
):OnBoardingDataRepository {
    override suspend fun cacheUser(userEntity: UserEntity) =
        appDao.addUser(userEntity=userEntity)

    override suspend fun getAllUsers(): Flow<List<UserEntity>> =
        appDao.getAllUsers()

}