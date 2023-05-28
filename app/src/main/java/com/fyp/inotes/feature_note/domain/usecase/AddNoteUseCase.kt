package com.fyp.inotes.feature_note.domain.usecase

import com.fyp.inotes.feature_note.domain.model.Note
import com.fyp.inotes.feature_note.domain.repostory.Repository
import com.fyp.inotes.feature_note.domain.util.InvalidNoteException

class AddNoteUseCase(private val repository: Repository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("Title can't be empty.")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("Content can't be empty.")
        }
        repository.insertNote(note)
    }
}