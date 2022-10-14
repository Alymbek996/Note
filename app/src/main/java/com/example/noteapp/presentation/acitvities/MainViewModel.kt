package com.example.noteapp.presentation.acitvities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.usecase.CreateNoteUseCase
import com.example.noteapp.domain.usecase.DeleteNoteUseCase
import com.example.noteapp.domain.usecase.EditNoteUseCase
import com.example.noteapp.domain.usecase.GetNoteAllUseCase
import com.example.noteapp.domain.utils.Resource
import com.example.noteapp.presentation.UIState
import com.example.noteapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNoteAllUseCase: GetNoteAllUseCase,
    private val editNoteUseCase: EditNoteUseCase,
    private val createNoteUseCase: CreateNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
):BaseViewModel() {

    private val _getAllNoteState = uiStateFlow<List<Note>>()
    val getNoteAllState = _getAllNoteState.asStateFlow()

    private val _getNoteState = uiStateFlow<Note>()
    val getNoteState = _getNoteState.asStateFlow()

    private val _createNoteState = uiStateFlow<Unit>()
    val createNoteState = _createNoteState.asStateFlow()

    private val _editNoteState = uiStateFlow<Unit>()
    val editNoteState = _editNoteState.asStateFlow()

    private val _deleteNoteState = uiStateFlow<Unit>()
    val deleteNoteState = _deleteNoteState.asStateFlow()

      fun getAllNotes(){
        getNoteAllUseCase.getAllNote().collectFlow(_getAllNoteState)
    }
      fun createNote(note: Note){
        createNoteUseCase.createNote(note).collectFlow(_createNoteState)
    }
      fun editNote(note: Note){
        editNoteUseCase.editNote(note).collectFlow(_editNoteState)
    }
      fun deleteNote(note: Note){
        deleteNoteUseCase.deleteNote(note).collectFlow(_deleteNoteState)
    }
}
