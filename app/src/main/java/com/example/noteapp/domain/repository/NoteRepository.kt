package com.example.noteapp.domain.repository

import com.example.noteapp.domain.model.Note

interface NoteRepository {
    fun createNote(note: Note)
    fun editNote(note:Note)
    fun deleteNote(note:Note)
    fun getAll()
}