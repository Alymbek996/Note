package com.example.noteapp.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.domain.utils.Resource
import com.example.noteapp.presentation.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel:ViewModel() {

    fun <T> uiStateFlow() = MutableStateFlow<UIState<T>>(UIState.Loading())

    protected fun <T> Flow<Resource<T>>.collectFlow(_state:MutableStateFlow<UIState<T>>){
            viewModelScope.launch {
                this@collectFlow.collect{
                    when(it){
                        is Resource.Loading ->{
                            _state.value = UIState.Loading()
                        }
                        is Resource.Error->{
                            _state.value = UIState.Error(it.message?:"Something went wrong")
                        }
                        is Resource.Success->{
                            if (it.data !=null){
                                _state.value = UIState.Success(it.data)
                            }
                        }
                    }
                }
            }
    }
}