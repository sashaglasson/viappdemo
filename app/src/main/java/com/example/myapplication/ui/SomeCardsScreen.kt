package com.example.myapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@Composable
fun SomeCardsScreen(){
    val things: List<Pair<String, Int>> = listOf(Pair("a cat", R.drawable.cat), Pair("a dog",
        R.drawable.dog
    ), Pair("a baby cow", R.drawable.babycow), Pair("a hamster", R.drawable.hamster))
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        things.forEach { thing ->
            MakeCard(thing.first, thing.second)
        }
    }
}

@Composable
fun MakeCard (text: String, img: Int, modifier: Modifier = Modifier){
    Card(modifier = Modifier) {
        Column {
            Image(
                painter = painterResource(img),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .height(195.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "This is a picture of $text",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )

        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
@Preview
fun CardPreview(){
    SomeCardsScreen()
}