package com.example.noteapp.domain.repository

import com.example.noteapp.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun createNote(note: Note):Flow<Unit>
    fun editNote(note:Note):Flow<Unit>
    fun deleteNote(note:Note):Flow<Unit>
    fun getAll():Flow<List<Note>>
}