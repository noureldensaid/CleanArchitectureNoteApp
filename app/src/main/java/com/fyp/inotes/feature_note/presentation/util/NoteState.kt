package com.fyp.inotes.feature_note.presentation.util

import com.fyp.inotes.feature_note.domain.model.Note
import com.fyp.inotes.feature_note.domain.util.NoteOrder
import com.fyp.inotes.feature_note.domain.util.OrderType

data class NoteState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
