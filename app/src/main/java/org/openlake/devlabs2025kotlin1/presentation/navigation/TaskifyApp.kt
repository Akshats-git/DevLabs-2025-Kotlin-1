package org.openlake.devlabs2025kotlin1.presentation.navigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tf.iitb.myapplication.presentation.notes.NoteScreen


@Composable
fun TaskifyApp(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    val startDestination = "notes"

    NavHost(navController = navController, startDestination = startDestination) {
        composable("login") {

        }

        composable("register") {
        }
        composable("tasks") {

        }
        composable("notes") {
            NoteScreen(
                notes = listOf(
                    Pair("Note 1", "This is the content of Note 1"),
                    Pair("Note 2", "This is the content of Note 2"),
                    Pair("Note 3", "This is the content of Note 3")
                ),
                onAddNote = { },
                onNoteClick = { },
                onNavigate = { },
                onLogout = { }
            )
        }
    }
}
