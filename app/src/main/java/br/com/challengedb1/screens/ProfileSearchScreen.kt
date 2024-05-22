package br.com.challengedb1.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import br.com.challengedb1.model.UserProfile

@Composable
fun ProfileSearchScreen(profiles: List<UserProfile>) {
//    var searchResults by remember { mutableStateOf(listOf<UserProfile>()) }
//
//    Column {
//        AdvancedSearchScreen { location, expertise, availability ->
//            searchResults = searchProfiles(profiles, location, expertise, availability)
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        if (searchResults.isNotEmpty()) {
//            Text("Search Results", style = MaterialTheme.typography.h6)
//            searchResults.forEach { profile ->
//                Text("Name: ${profile.name}")
//                Text("Role: ${profile.role}")
//                Text("Location: ${profile.location}")
//                Text("Expertise: ${profile.skills.joinToString(", ")}")
//                Text("Availability: ${profile.availability}")
//                Spacer(modifier = Modifier.height(8.dp))
//            }
//        } else {
//            Text("No profiles found.")
//        }
//    }
}