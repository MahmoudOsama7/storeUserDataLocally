package com.example.gatherdInformation.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.gatherdInformation.model.GatheredInformationViewState
import com.example.onboarding.R

@Composable
fun GatheredInformationScreen(
    onBackPressed:()->Unit,
    viewModel: GatheredInformationViewModel
){
    val state = viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getStoredUsers()
    }

    GatheredInformationScreenContent(
        state=state.value,
        onBackPressed=onBackPressed
    )
}

@Composable
fun GatheredInformationScreenContent(
    state:GatheredInformationViewState,
    onBackPressed:()->Unit,
){
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(1){
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onBackPressed() },
            )
            Spacer(Modifier.height(20.dp))

            Text(
                text= stringResource(R.string.gathered_information)
            )
        }
        itemsIndexed(state.users){index,user->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Spacer(Modifier.height(15.dp))
                Text(
                    text= stringResource(R.string.user).plus(" ").plus(index.plus(1))
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text= stringResource(R.string.username)
                    )
                    Text(
                        text= user.userName
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text= stringResource(R.string.age)
                    )
                    Text(
                        text= user.age
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text= stringResource(R.string.gender)
                    )
                    Text(
                        text= user.gender
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text= stringResource(R.string.job_title)
                    )
                    Text(
                        text= user.jobTitle
                    )
                }
            }
        }
    }
}