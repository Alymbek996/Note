package com.example.noteapp.domain.usecase

import com.example.noteapp.domain.repository.NoteRepository

class GetNoteAllUseCase(
    private val noteRepository: NoteRepository
    ) {
    fun getAllNote()=noteRepository.getAll()

}