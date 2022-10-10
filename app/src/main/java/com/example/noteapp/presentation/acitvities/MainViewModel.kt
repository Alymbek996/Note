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

    private val _getAllNoteState = MutableStateFlow<UIState<List<Note>>>(UIState.Loading())
    val getNoteAllState = _getAllNoteState.asStateFlow()

    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val createNoteState = _createNoteState.asStateFlow()

    private val _editNoteState = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val editNoteState = _editNoteState.asStateFlow()

    private val _deleteNoteState = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val deleteNoteState = _deleteNoteState.asStateFlow()

     suspend fun getAllNotes(){
        getNoteAllUseCase.getAllNote().collectFlow(_getAllNoteState)
    }
     suspend fun createNote(note: Note){
        createNoteUseCase.createNote(note).collectFlow(_createNoteState)
    }
     suspend fun editNote(note: Note){
        editNoteUseCase.editNote(note).collectFlow(_editNoteState)
    }
     suspend fun deleteNote(note: Note){
        deleteNoteUseCase.deleteNote(note).collectFlow(_deleteNoteState)
    }
}