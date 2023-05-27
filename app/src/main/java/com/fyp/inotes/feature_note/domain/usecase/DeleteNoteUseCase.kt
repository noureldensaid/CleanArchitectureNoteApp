package com.fyp.inotes.feature_note.domain.usecase

import com.fyp.inotes.feature_note.domain.model.Note
import com.fyp.inotes.feature_note.domain.repostory.Repository

class DeleteNoteUseCase(private val repository: Repository) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }

}