package com.example.onboaarding_data.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.onboaarding_data.data.local.data.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(userEntity: UserEntity)

    @Query(value = "SELECT * FROM users")
    fun getAllUsers(): Flow<List<UserEntity>>
}