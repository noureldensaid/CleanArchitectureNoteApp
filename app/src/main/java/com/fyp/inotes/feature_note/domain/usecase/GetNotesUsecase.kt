package com.fyp.inotes.feature_note.domain.usecase

import com.fyp.inotes.feature_note.domain.model.Note
import com.fyp.inotes.feature_note.domain.repostory.Repository
import com.fyp.inotes.feature_note.domain.util.NoteOrder
import com.fyp.inotes.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUsecase(private val repository: Repository) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when (noteOrder.orderType) {
                is OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                        is NoteOrder.Date -> notes.sortedBy { it.timeStamp }
                    }
                }

                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timeStamp }
                    }
                }
            }

        }
    }

}