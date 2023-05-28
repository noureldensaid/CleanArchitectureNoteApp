package com.fyp.inotes.feature_note.domain.usecase

data class NoteUseCases(
    val getNotesUsecase: GetNotesUsecase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val addNoteUseCases: AddNoteUseCase
)
