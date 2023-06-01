package com.fyp.inotes.feature_note.domain.usecase

import com.fyp.inotes.feature_note.domain.model.Note
import com.fyp.inotes.feature_note.domain.repostory.Repository

class GetNoteByIdUsecase(private val repository: Repository) {
    suspend operator fun invoke(noteId: Int): Note? {
        return repository.getNoteById(noteId)
    }


}