package com.fyp.inotes.feature_note.presentation.add_edit_note

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.fyp.inotes.feature_note.domain.model.Note
import com.fyp.inotes.feature_note.presentation.add_edit_note.componenets.ColorBubble
import com.fyp.inotes.feature_note.presentation.add_edit_note.componenets.TransparentHintTextField
import com.fyp.inotes.feature_note.presentation.util.UiEvent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun AddEditNoteScreen(
    navigator: NavController,
    noteColor: Int,
    viewModel: AddEditNoteViewModel = hiltViewModel()
) {
    val noteTitle = viewModel.noteTitle
    val noteContent = viewModel.noteContent
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val backgroundAnimatable = remember {
        Animatable(
            Color((if (noteColor != -1) noteColor else viewModel.noteColor.value))
        )
    }

    LaunchedEffect(key1 = true) {
        // handle navigation and showing snack bar
        viewModel.uiEventFlow.collectLatest { event ->
            when (event) {

                is UiEvent.NavigateOnSaveNote -> {
                    navigator.navigateUp()
                }

                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }

                else -> {}
            }
        }

    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.onEvent(AddEditNoteEvent.SaveNote) },
                backgroundColor = MaterialTheme.colors.primary,
            ) {
                Icon(imageVector = Icons.Default.Save, contentDescription = "save")
            }
        },
        scaffoldState = scaffoldState
    ) { padding ->
        Column(
            modifier = Modifier
                .background(backgroundAnimatable.value)
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {

            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Note.noteColors.forEach { itemColor ->
                    ColorBubble(
                        modifier = Modifier
                            .clickable {
                                coroutineScope.launch {
                                    backgroundAnimatable.animateTo(
                                        targetValue = itemColor,
                                        animationSpec = tween(500)
                                    )
                                }
                                viewModel.onEvent(AddEditNoteEvent.ChangeColor(itemColor.toArgb()))
                            }
                            .border(
                                width = 2.dp,
                                shape = CircleShape,
                                color = if (viewModel.noteColor.value == itemColor.toArgb())
                                    Color.DarkGray else Color.Transparent
                            ),
                        colorInt = itemColor.toArgb(),
                    )

                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            TransparentHintTextField(
                text = noteTitle.value.text,
                hint = noteTitle.value.hint,
                onValueChange = { viewModel.onEvent(AddEditNoteEvent.EnteredTitle(it)) },
                onFocusChange = { viewModel.onEvent(AddEditNoteEvent.ChangeTitleFocus(it)) },
                singleLine = true,
                isHintVisible = noteTitle.value.isHintVisible,
                textStyle = MaterialTheme.typography.h4,
              )

            Spacer(modifier = Modifier.height(16.dp))

            TransparentHintTextField(
                modifier = Modifier.fillMaxHeight(),
                text = noteContent.value.text,
                hint = noteContent.value.hint,
                onValueChange = { viewModel.onEvent(AddEditNoteEvent.EnteredContent(it)) },
                onFocusChange = { viewModel.onEvent(AddEditNoteEvent.ChangeContentFocus(it)) },
                isHintVisible = noteContent.value.isHintVisible,
                textStyle = MaterialTheme.typography.body1,
            )
        }


    }

}