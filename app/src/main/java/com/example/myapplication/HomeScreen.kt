package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Text(
            text = "Animal App",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {navController.navigate(AnimalScreens.Information.name)},
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Information")
        }
        Button(
            onClick = {navController.navigate(AnimalScreens.SomeCards.name)},
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Identifying animals")
        }
        Button(
            onClick = {navController.navigate(AnimalScreens.Login.name)},
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Log Out")
        }
    }
}
