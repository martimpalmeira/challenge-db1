package br.com.challengedb1.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AdvancedSearchScreen(navController: NavController) {
    var location by remember { mutableStateOf("") }
    var expertise by remember { mutableStateOf("") }
    var availability by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Advanced Search", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(8.dp))
        Text("Location")
        TextField(value = location, onValueChange = { location = it }, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(8.dp))
        Text("Expertise (comma separated)")
        TextField(value = expertise, onValueChange = { expertise = it }, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(8.dp))
        Text("Availability")
        TextField(value = availability, onValueChange = { availability = it }, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
//            onSearch(location, expertise, availability)
        }) {
            Text("Search")
        }
    }
}