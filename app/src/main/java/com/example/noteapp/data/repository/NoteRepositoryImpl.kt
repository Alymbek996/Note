package com.example.noteapp.data.repository

import com.example.noteapp.data.base.BaseRepository
import com.example.noteapp.data.localdb.NoteDao
import com.example.noteapp.data.mapper.noteEntityToNote
import com.example.noteapp.data.mapper.noteToNoteEntity
import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.repository.NoteRepository
import com.example.noteapp.domain.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

 class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
    ) :NoteRepository,BaseRepository() {
    override  fun createNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.createNote(note.noteToNoteEntity())
    }

    override  fun editNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.edit(note.noteToNoteEntity())
    }

    override  fun deleteNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.deleteNote(note.noteToNoteEntity())
    }

    override  fun getAll(): Flow<Resource<List<Note>>> = doRequest {
        noteDao.getAllNotes().map { it.noteEntityToNote() }
    }
    }