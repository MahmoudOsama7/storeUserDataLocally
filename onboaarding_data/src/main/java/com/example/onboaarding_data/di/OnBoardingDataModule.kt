package com.example.onboaarding_data.di

import android.content.Context
import androidx.room.Room
import com.example.onboaarding_data.data.local.db.APP_DB
import com.example.onboaarding_data.data.local.db.AppDB
import com.example.onboaarding_data.data.local.db.AppDao
import com.example.onboaarding_data.data.repository.OnBoardingDataRepositoryImpl
import com.example.onboaarding_data.domain.repository.OnBoardingDataRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object OnBoardingModule {


    @Provides
    @ActivityRetainedScoped
    fun provideAppDao(
        database: AppDB
    ): AppDao {
        return database.getAppDB()
    }


    @Provides
    @ActivityRetainedScoped
    fun provideAppsDB(
        @ApplicationContext applicationContext: Context
    ): AppDB = Room.databaseBuilder(
        applicationContext,
        AppDB::class.java,
        APP_DB
    ).fallbackToDestructiveMigration()
        .build()

    @Module
    @InstallIn(ViewModelComponent::class)
    interface OnBoardingDataBindModule {
        @Binds
        @ViewModelScoped
        fun bindOnBoardingDataRepository(
            onBoardingDataRepositoryImpl: OnBoardingDataRepositoryImpl
        ): OnBoardingDataRepository


    }
}