package com.example.noteapp.domain.usecase

import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.repository.NoteRepository
import javax.inject.Inject


class CreateNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
      fun createNote(note: Note)=noteRepository.createNote(note)

}