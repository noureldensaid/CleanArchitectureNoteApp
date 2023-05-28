package com.fyp.inotes.feature_note.presentation.note

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fyp.inotes.feature_note.domain.model.Note
import com.fyp.inotes.feature_note.domain.usecase.NoteUseCases
import com.fyp.inotes.feature_note.domain.util.NoteOrder
import com.fyp.inotes.feature_note.domain.util.OrderType
import com.fyp.inotes.feature_note.presentation.util.NoteEvent
import com.fyp.inotes.feature_note.presentation.util.NoteState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteScreenViewModel @Inject constructor(
    private val useCases: NoteUseCases
) : ViewModel() {
    
    // ui states
    private val _state = mutableStateOf(NoteState())
    val state: State<NoteState> = _state

    private var recentlyDeletedNote: Note? = null

    private var getNotesJob: Job? = null

    init {
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    // events or actions user can do
    fun onEvent(event: NoteEvent) {

        when (event) {

            is NoteEvent.Order -> {
                if (state.value.noteOrder::class == event.noteOrder::class
                    && state.value.noteOrder.orderType == event.noteOrder.orderType
                ) return

                getNotes(event.noteOrder)

            }

            is NoteEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }

            is NoteEvent.DeleteNote -> {
                viewModelScope.launch {
                    useCases.deleteNoteUseCase(event.note)
                    recentlyDeletedNote = event.note
                }
            }

            is NoteEvent.RestoreNote -> {
                viewModelScope.launch {
                    // add recently deleted again
                    useCases.addNoteUseCases(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }
        }

    }

    private fun getNotes(noteOrder: NoteOrder) {

        getNotesJob?.cancel()
        getNotesJob = useCases.getNotesUsecase(noteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )
            }.launchIn(viewModelScope)

    }

}