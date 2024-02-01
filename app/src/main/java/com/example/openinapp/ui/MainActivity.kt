package com.example.openinapp.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.openinapp.data.api.MainViewModel
import com.example.openinapp.data.api.Resource
import com.example.openinapp.data.api.models.OpenInAppResponse
import com.example.openinapp.navigation.NavigationComposable
import com.example.openinapp.ui.composable.GetScreenProgressbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val context = LocalContext.current
            val results = viewModel.results.collectAsState()

            results.value?.let {
                when (it) {
                    is Resource.Failure -> {
                        Log.e("The error:", it.exception.message!!)
                        Toast.makeText(
                            context,
                            it.exception.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    Resource.Loading -> {
                        GetScreenProgressbar()
                    }

                    is Resource.Success -> {

                        MyApp(it.result)
                    }

                    else -> {
                        TODO("Pass one of the Resource here")
                    }
                }
            }

        }
    }
}


@Composable
fun MyApp(response: OpenInAppResponse) {
    val apiResponse by remember { mutableStateOf(response) }
    NavigationComposable(apiResponse = apiResponse)
}


