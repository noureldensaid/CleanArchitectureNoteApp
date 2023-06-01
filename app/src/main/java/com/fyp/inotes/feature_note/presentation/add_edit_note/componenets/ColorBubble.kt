package com.fyp.inotes.feature_note.presentation.add_edit_note.componenets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorBubble(
    modifier: Modifier,
    colorInt: Int,
) {
    Box(
        modifier = modifier
            .size(50.dp)
            .clip(CircleShape)
            .shadow(15.dp, CircleShape)
            .background(Color(colorInt))
    )
}