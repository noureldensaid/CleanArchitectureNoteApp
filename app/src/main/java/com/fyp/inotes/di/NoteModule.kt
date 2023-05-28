package com.fyp.inotes.di

import android.app.Application
import androidx.room.Room
import com.fyp.inotes.feature_note.data.local.NoteDatabase
import com.fyp.inotes.feature_note.data.local.NoteDatabase.Companion.DATABASE_NAME
import com.fyp.inotes.feature_note.data.repository.RepositoryImpl
import com.fyp.inotes.feature_note.domain.repostory.Repository
import com.fyp.inotes.feature_note.domain.usecase.AddNoteUseCase
import com.fyp.inotes.feature_note.domain.usecase.DeleteNoteUseCase
import com.fyp.inotes.feature_note.domain.usecase.GetNotesUsecase
import com.fyp.inotes.feature_note.domain.usecase.NoteUseCases
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(Singleton::class)
object NoteModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(@ApplicationContext app: Application): NoteDatabase {
        return Room.databaseBuilder(
            context = app,
            klass = NoteDatabase::class.java,
            name = DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(database: NoteDatabase): Repository {
        return RepositoryImpl(database.dao)
    }

    @Provides
    @Singleton
    fun provideNoteUsecases(repository: Repository): NoteUseCases {
        return NoteUseCases(
            getNotesUsecase = GetNotesUsecase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
            addNoteUseCases = AddNoteUseCase(repository)
        )
    }

}