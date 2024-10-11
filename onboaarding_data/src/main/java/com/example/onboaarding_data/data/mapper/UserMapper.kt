package com.example.onboaarding_data.data.mapper

import com.example.onboaarding_data.data.local.data.UserEntity
import com.example.onboaarding_data.data.remote.data.User

fun User.toUserEntity():UserEntity =
    UserEntity(
        id = 0,
        userName = userName,
        jobTitle = jobTitle,
        age = age,
        gender = gender
    )


fun UserEntity.toUser(): User =
    User(
        userName = userName.orEmpty(),
        jobTitle = jobTitle.orEmpty(),
        age = age.orEmpty(),
        gender = gender.orEmpty()
    )

