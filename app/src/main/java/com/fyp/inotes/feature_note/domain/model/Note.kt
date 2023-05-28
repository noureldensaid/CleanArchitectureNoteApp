package com.fyp.inotes.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fyp.inotes.ui.theme.BabyBlue
import com.fyp.inotes.ui.theme.LightGreen
import com.fyp.inotes.ui.theme.RedOrange
import com.fyp.inotes.ui.theme.RedPink
import com.fyp.inotes.ui.theme.Violet

@Entity(tableName = Note.NOTE_TABLE)
data class Note(
    val title: String,
    val content: String,
    val color: Long,
    val timeStamp: Long,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
        const val NOTE_TABLE = "note"
    }
}


