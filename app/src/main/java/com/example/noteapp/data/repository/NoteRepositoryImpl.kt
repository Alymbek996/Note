package com.example.noteapp.data.repository

import com.example.noteapp.data.localdb.NoteDao
import com.example.noteapp.data.mapper.noteEntityToNote
import com.example.noteapp.data.mapper.noteToNoteEntity
import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
    ) :NoteRepository {


    override fun createNote(note: Note):Flow<Unit> = flow {
            noteDao.createNote(note.noteToNoteEntity())
        }

    override fun editNote(note: Note):Flow<Unit> = flow {
            noteDao.edit(note.noteToNoteEntity())
        }


    override fun deleteNote(note: Note):Flow<Unit> =flow {
            noteDao.deleteNote(note.noteToNoteEntity())
        }

    override fun getAll():Flow<List<Note>> = flow {
            noteDao.getAllNotes().map { it.noteEntityToNote() }
        }
    }
