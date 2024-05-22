package br.com.challengedb1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.challengedb1.model.Match
import br.com.challengedb1.model.Role
import br.com.challengedb1.model.UserProfile
import br.com.challengedb1.screens.AdvancedSearchScreen
import br.com.challengedb1.screens.ProfileCreationScreen
import br.com.challengedb1.ui.theme.ChallengeDB1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChallengeDB1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "advenced-search",
                        enterTransition = {
                            slideIntoContainer(
                                towards = (AnimatedContentTransitionScope.SlideDirection.Start),
                                animationSpec = tween(700)
                            )
                        },
                        exitTransition = {
                            slideOutOfContainer(
                                towards = (AnimatedContentTransitionScope.SlideDirection.Start),
                                animationSpec = tween(700)
                            )
                        }) {
                        composable(route = "profile-creation") {
                            ProfileCreationScreen(navController)

                        }

                        composable(route = "advenced-search") {
                            AdvancedSearchScreen(navController)

                        }


                    }
                }
            }
        }
    }
}

fun findMatches(profiles: List<UserProfile>): List<Match> {
    val mentors = profiles.filter { it.role == Role.MENTOR }
    val apprentices = profiles.filter { it.role == Role.APPRENTICE }
    val matches = mutableListOf<Match>()

    for (mentor in mentors) {
        for (apprentice in apprentices) {
            val commonInterests = mentor.interests.intersect(apprentice.interests).toList()
            if (commonInterests.isNotEmpty()) {
                matches.add(Match(mentor, apprentice, commonInterests))
            }
        }
    }

    return matches
}


