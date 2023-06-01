package com.fyp.inotes.core.navigation

sealed class Screen(val route: String) {
    object NoteScreen : Screen("note_screen")
    object AddEditNoteScreen : Screen("add_edit_note_screen")

    // pass args ext function
    // works only with mandatory args
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
