package com.example.myapplication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
){
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Spacer(modifier = Modifier.size(25.dp))
        Text(
            text = "Login Screen",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.size(25.dp))
        var username by remember{ mutableStateOf("") }
        TextField(value = username, onValueChange = {username = it }, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(25.dp))
        var password by remember{ mutableStateOf("") }
        TextField(value = password, onValueChange = {password = it }, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(25.dp))
        Button(
            onClick = {
                if(username == "MissGlasson" && password == "Hello123"){
                    navController.navigate(AnimalScreens.HomeScreen.name)
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ){
            Text("Login")
        }
    }
}
