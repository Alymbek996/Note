package com.example.noteapp.data.repository

import com.example.noteapp.App
import com.example.noteapp.data.mapper.noteToNoteEntity
import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.repository.NoteRepository

class NoteRepositoryImpl:NoteRepository {

    private val noteDao = App.roomDatabase.noteDao()

    override fun createNote(note: Note) {
        noteDao.createNote(note.noteToNoteEntity())
    }

    override fun editNote(note: Note) {
        noteDao.edit(note.noteToNoteEntity())
    }

    override fun deleteNote(note: Note) {
    noteDao.deleteNote(note.noteToNoteEntity())
        }

    override fun getAll() {
        noteDao.getAllNotes()
    }
}