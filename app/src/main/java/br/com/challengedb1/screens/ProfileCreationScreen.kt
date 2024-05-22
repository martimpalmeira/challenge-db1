package br.com.challengedb1.screens

import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.challengedb1.model.Role
import br.com.challengedb1.model.UserProfile
import java.util.*

@Composable
fun ProfileCreationScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var role by remember { mutableStateOf(Role.APPRENTICE) }
    var experience by remember { mutableStateOf("") }
    var skills by remember { mutableStateOf("") }
    var interests by remember { mutableStateOf("") }
    var education by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Create Profile", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(8.dp))
        Text("Name")
        TextField(value = name, onValueChange = { name = it })

        Spacer(modifier = Modifier.height(8.dp))
        Text("Role")
        Row {
            RadioButton(
                selected = role == Role.MENTOR,
                onClick = { role = Role.MENTOR }
            )
            Text("Mentor")
            Spacer(modifier = Modifier.width(8.dp))
            RadioButton(
                selected = role == Role.APPRENTICE,
                onClick = { role = Role.APPRENTICE }
            )
            Text("Apprentice")
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text("Experience")
        TextField(value = experience, onValueChange = { experience = it })

        Spacer(modifier = Modifier.height(8.dp))
        Text("Skills (comma separated)")
        TextField(value = skills, onValueChange = { skills = it })

        Spacer(modifier = Modifier.height(8.dp))
        Text("Interests (comma separated)")
        TextField(value = interests, onValueChange = { interests = it })

        Spacer(modifier = Modifier.height(8.dp))
        Text("Education")
        TextField(value = education, onValueChange = { education = it })

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val profile = UserProfile(
                id = UUID.randomUUID().toString(),
                name = name,
                role = role,
                experience = experience,
                skills = skills.split(",").map { it.trim() },
                interests = interests.split(",").map { it.trim() },
                education = education
            )
           // onProfileCreated(profile)
        }) {
            Text("Create Profile")
        }
    }
}
