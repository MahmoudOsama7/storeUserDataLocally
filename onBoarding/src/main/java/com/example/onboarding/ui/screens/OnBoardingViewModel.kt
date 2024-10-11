package com.example.onboarding.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onboaarding_data.domain.useCase.CacheUserUseCase
import com.example.onboarding.model.OnBoardingViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val cacheUserUseCase: CacheUserUseCase,
):ViewModel(){
    private val _state: MutableStateFlow<OnBoardingViewState> = MutableStateFlow(OnBoardingViewState())
    val state: StateFlow<OnBoardingViewState> = _state.asStateFlow()

    fun onUserNameChanged(userName:String){
        _state.update {
            it.copy(
                user = state.value.user.copy(userName=userName)
            )
        }
        validateInputs()
    }

    fun onAgeChanged(age:String){
        _state.update {
            it.copy(
                user = state.value.user.copy(age=age)
            )
        }
        validateInputs()
    }
    fun onJobTitleChanged(jobTitle:String){
        _state.update {
            it.copy(
                user = state.value.user.copy(jobTitle=jobTitle)
            )
        }
        validateInputs()
    }
    fun onGenderChanged(gender:String){
        _state.update {
            it.copy(
                user = state.value.user.copy(gender=gender)
            )
        }
        validateInputs()
    }

    fun storeUser(){
        viewModelScope.launch(Dispatchers.IO) {
            cacheUserUseCase(user = state.value.user)
        }
    }

    fun validateInputs(){
        _state.update {
            it.copy(
                buttonIsEnabled = state.value.user.userName.isNotEmpty() &&
                        state.value.user.age.isNotEmpty() &&
                        state.value.user.gender.isNotEmpty() &&
                        state.value.user.jobTitle.isNotEmpty()
            )
        }
    }
}