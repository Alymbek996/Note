package com.example.noteapp.domain.repository

import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.utils.Resource
import kotlinx.coroutines.flow.Flow


interface NoteRepository {
   suspend fun createNote(note: Note):Flow<Resource<Unit>>
   suspend fun editNote(note:Note):Flow<Resource<Unit>>
  suspend  fun deleteNote(note:Note):Flow<Resource<Unit>>
  suspend  fun getAll():Flow<Resource<List<Note>>>
}