package com.example.noteapp.domain.usecase

import com.example.noteapp.domain.repository.NoteRepository
import dagger.Binds
import javax.inject.Inject

  class GetNoteAllUseCase @Inject constructor(
    private val noteRepository: NoteRepository
    ) {

        fun getAllNote()=noteRepository.getAll()

}