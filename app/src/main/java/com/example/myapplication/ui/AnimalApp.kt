package com.example.myapplication.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


enum class AnimalScreens(var title: String){
    Login(title = "Login"),
    Information(title = "Information"),
    SomeCards(title = "Animal Cards"),
    HomeScreen(title = "Home");
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalAppBar(
    currentScreen : AnimalScreens,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = { Text(currentScreen.title) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack){
                IconButton(onClick = navigateUp){
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back Button"
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalApp(
    navController: NavHostController = rememberNavController()
){
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AnimalScreens.valueOf(
        backStackEntry?.destination?.route ?: AnimalScreens.Login.name
    )
    Scaffold(
        topBar = {
            AnimalAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ){ innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AnimalScreens.Login.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = AnimalScreens.Login.name){
                LoginScreen(
                    navController = navController
                )
            }
            composable(route = AnimalScreens.HomeScreen.name){
                HomeScreen(navController)
            }
            composable(route = AnimalScreens.Information.name){
                InformationScreen()
            }
            composable(route = AnimalScreens.SomeCards.name){
                SomeCardsScreen()
            }
        }
    }
}