package com.fyp.inotes.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fyp.inotes.feature_note.presentation.add_edit_note.AddEditNoteScreen
import com.fyp.inotes.feature_note.presentation.note.NoteScreen

@Composable
fun MainNavigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.NoteScreen.route,
    ) {
        composable(route = Screen.NoteScreen.route) { NoteScreen(navController) }
        composable(
            route = Screen.AddEditNoteScreen.route + "?noteId={noteId}&noteColor={noteColor}",
            arguments = listOf(
                navArgument(name = "noteId") {
                    type = NavType.IntType
                    defaultValue = -1
                },
                navArgument(name = "noteColor") {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        )
        { entry ->
            val color = entry.arguments?.getInt("noteColor") ?: -1
            AddEditNoteScreen(navController, color)
        }
    }
}