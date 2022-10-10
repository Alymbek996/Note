package com.example.noteapp.data.mapper

import com.example.noteapp.data.model.NoteEntity
import com.example.noteapp.domain.model.Note

fun Note.noteToNoteEntity()=NoteEntity(
    id=id,
    text=text,
    title = title
)

fun NoteEntity.noteEntityToNote()=Note(
    id=id,
    text=text,
    title = title,

)