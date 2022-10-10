package com.example.noteapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity
data class Note (
    @PrimaryKey(autoGenerate = true)
    val id: Int = Default_ID,
    var title: String,
    val text: String
        ):Serializable{
    constructor():this(0,"","")
    companion object{
        const val Default_ID = 0
    }
}