package com.example.noteapp.presentation.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.noteapp.presentation.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment : Fragment() {

    protected fun <T> StateFlow<UIState<T>>.collectStates(
        onLoading:()-> Unit,
        onError: (msg:String)-> Unit,
        onSuccess: (data:T)-> Unit
    ){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                this@collectStates.collect{
                    when(it){
                        is UIState.Loading->{
                            onLoading()
                        }
                        is UIState.Error->{
                            onError(it.error)
                        }
                        is UIState.Success->{
                           onSuccess(it.data)
                        }
                    }
                }
            }
        }
    }
}