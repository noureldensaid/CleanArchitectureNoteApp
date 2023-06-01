package com.fyp.inotes.feature_note.presentation.util

sealed class UiEvent {
    data class ShowSnackbar(val message: String) : UiEvent()
    object NavigateOnSaveNote : UiEvent()
    object DeleteNote : UiEvent()
}
