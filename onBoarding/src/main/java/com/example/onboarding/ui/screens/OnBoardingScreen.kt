package com.example.onboarding.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onboarding.R
import com.example.onboarding.model.OnBoardingViewState

@Composable
fun OnBoardingScreen(
    viewModel:OnBoardingViewModel,
    onContinueClicked:()->Unit
){
    val state = viewModel.state.collectAsState()

    OnBoardingScreenContent(
        state=state.value,
        onUserNameChanged=viewModel::onUserNameChanged,
        onAgeChanged=viewModel::onAgeChanged,
        onJobTitleChanged=viewModel::onJobTitleChanged,
        onGenderChanged=viewModel::onGenderChanged,
        onContinueClicked = {
            viewModel.storeUser()
            onContinueClicked()
        }
    )
}


@Composable
fun OnBoardingScreenContent(
    state:OnBoardingViewState,
    onUserNameChanged:(String)->Unit,
    onAgeChanged:(String)->Unit,
    onJobTitleChanged:(String)->Unit,
    onGenderChanged:(String)->Unit,
    onContinueClicked:()->Unit
){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text= stringResource(R.string.gathering_information),
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text= stringResource(R.string.username),
            )
            TextField(
                value = state.user.userName,
                onValueChange = onUserNameChanged
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text= stringResource(R.string.age),
            )
            TextField(
                value = state.user.age,
                onValueChange = onAgeChanged
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text= stringResource(R.string.job_title),
            )
            TextField(
                value = state.user.jobTitle,
                onValueChange = onJobTitleChanged
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text= stringResource(R.string.gender),
            )
            TextField(
                value = state.user.gender,
                onValueChange = onGenderChanged
            )
        }
        Box(){
            PrimaryButton(
                label = stringResource(R.string._continue),
                onClick =onContinueClicked,
                isEnabled=state.buttonIsEnabled
            )
        }
    }
}


@Composable
fun PrimaryButton(
    label: String,
    isEnabled:Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        enabled = isEnabled,
        onClick = onClick,
        modifier = modifier.fillMaxWidth().padding(16.dp)
    ) {
        Text(
            text = label,
            fontSize = 18.sp
        )
    }
}