package com.fyp.inotes.feature_note.domain.repostory

import com.fyp.inotes.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

//definition
interface Repository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun deleteNote(note: Note)

    suspend fun insertNote(note: Note)
}