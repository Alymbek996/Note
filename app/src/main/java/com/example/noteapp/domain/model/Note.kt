package com.example.noteapp.domain.model

data class Note (
    val id: Int = Default_ID,
    val title: String,
    val text: String
        ){
    companion object{
        const val Default_ID = 0
    }
}