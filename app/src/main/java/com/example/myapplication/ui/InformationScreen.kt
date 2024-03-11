package com.example.myapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@Composable
fun InformationScreen(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.SpaceBetween
    ){
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ){
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = "This is a cat",
            modifier = modifier.fillMaxWidth().height(200.dp)
        )
        Spacer(modifier = modifier.height(16.dp))
        Text(
            text = "Cats",
            style = MaterialTheme.typography.titleMedium,
            modifier= modifier.padding(30.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
        )
        Spacer(modifier = modifier.height(16.dp))
        Text(
            text = "Cat, (Felis catus), domesticated member of the family Felidae, order Carnivora, and the smallest member of that family. Like all felids, domestic cats are characterized by supple low-slung bodies, finely molded heads, long tails that aid in balance, and specialized teeth and claws that adapt them admirably to a life of active hunting. Cats possess other features of their wild relatives in being basically carnivorous, remarkably agile and powerful, and finely coordinated in movement.\n" +
                    "\n" +
                    "It is noteworthy that the ancestors of the other common household pet, the dog, were social animals that lived together in packs in which there was subordination to a leader, and the dog has readily transferred its allegiance from pack leader to human master. The cat, however, has not yielded as readily to subjugation. Consequently, the house cat is able to revert to complete self-reliance more quickly and more successfully than most domesticated dogs. For an account of the relationship of the family of cats to other carnivores, see carnivore.\n" +
                    "\n" +
                    "Origin and history of cats\n" +
                    "The “cat pattern,” established very early in the evolution of modern mammals, was a successful one: early cats were already typical in form at a time when the ancestors of most other modern mammalian types were scarcely recognizable. They first appeared in the early Pliocene Epoch (5.3 to 3.6 million years ago), and they have continued with remarkably little change into modern times."
        )
    }
}

@Composable
@Preview(showBackground = true)
fun InfoPreview(){
    InformationScreen()
}