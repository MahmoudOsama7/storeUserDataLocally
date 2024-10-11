package com.example.onboaarding_data.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.onboaarding_data.data.local.data.UserEntity

const val APP_DB = "database"
@Database(
    entities = [UserEntity::class],
    version = 1
)

abstract class AppDB : RoomDatabase() {
    abstract fun getAppDB(): AppDao
}