package com.fyp.inotes.feature_note.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fyp.inotes.feature_note.domain.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract val dao: NoteDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}