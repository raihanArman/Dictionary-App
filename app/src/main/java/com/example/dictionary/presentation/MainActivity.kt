package com.example.dictionary.presentation


import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.dictionary.R
import com.example.dictionary.presentation.feature.home.HomeScreen
import com.example.dictionary.presentation.feature.home.HomeViewModel
import com.raihanarman.dictionaryapp.ui.theme.DictionaryAppTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = getViewModel<HomeViewModel>()
        setContent {
            DictionaryAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ){
                    HomeScreen(viewModel)
                }
            }
        }
    }
}