package com.example.gatherdInformation.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gatherdInformation.model.GatheredInformationViewState
import com.example.onboaarding_data.domain.useCase.GetCachedUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GatheredInformationViewModel @Inject constructor(
    private val getCachedUsersUseCase: GetCachedUsersUseCase
):ViewModel() {

    private val _state: MutableStateFlow<GatheredInformationViewState> = MutableStateFlow(GatheredInformationViewState())
    val state: StateFlow<GatheredInformationViewState> = _state.asStateFlow()


    fun getStoredUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                it.copy(
                    users = getCachedUsersUseCase()
                )
            }
        }
    }
}