package com.fyp.inotes.feature_note.domain.usecase

data class NoteUsecases(
    val getNotesUsecase: GetNotesUsecase,
    val deleteNoteUsecase: DeleteNoteUsecase,
    val addNoteUsecase: AddNoteUsecase,
    val getNoteByIdUsecase: GetNoteByIdUsecase
)
