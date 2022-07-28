package com.example.dictionary.presentation.feature.home

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dictionary.R
import com.example.dictionary.presentation.component.WordItem
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */
@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    val scaffoldState = rememberScaffoldState()
    val state = viewModel.state.value

    LaunchedEffect(key1 = true){
        viewModel.eventFlow.collectLatest { event ->
            when(event){
                is HomeViewModel.UIEvent.ShowSnackbar ->{
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                TextField(
                    value = viewModel.searchQuery.value,
                    onValueChange = viewModel::onSearch,
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(stringResource(R.string.search_hint))
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))

                if(state.isLoading) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        CircularProgressIndicator()
                    }
                }else{
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ){
                        items(state.wordInfoItems.size){i ->
                            val wordInfo = state.wordInfoItems[i]
                            if(i > 0){
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                            WordItem(wordInfo = wordInfo)
                            if(i < state.wordInfoItems.size - 1){
                                Divider()
                            }
                        }
                    }
                }
            }
        }
    }
}