package com.fyp.inotes.feature_note.data.repository

import com.fyp.inotes.feature_note.data.local.NoteDao
import com.fyp.inotes.feature_note.domain.model.Note
import com.fyp.inotes.feature_note.domain.repostory.Repository
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val dao: NoteDao
) : Repository {

    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }
}
