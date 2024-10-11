package com.example.onboaarding_data.data.local.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userName:String?,
    val age:String?,
    val jobTitle:String?,
    val gender:String?
)
