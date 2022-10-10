package com.example.noteapp.domain.repository

import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.utils.Resource
import kotlinx.coroutines.flow.Flow


interface NoteRepository {
    fun createNote(note: Note):Flow<Resource<Unit>>
    fun editNote(note:Note):Flow<Resource<Unit>>
    fun deleteNote(note:Note):Flow<Resource<Unit>>
    fun getAll():Flow<Resource<List<Note>>>
}