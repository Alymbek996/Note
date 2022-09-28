package com.example.noteapp

import android.app.Application
import androidx.room.Room
import com.example.noteapp.data.localdb.NoteDataBase

class App:Application() {
    companion object{
        lateinit var roomDatabase:NoteDataBase
    }

    override fun onCreate() {
        super.onCreate()
        roomDatabase = Room.databaseBuilder(
            applicationContext,
            NoteDataBase::class.java,
            "note_db"
        ).allowMainThreadQueries()
            .build()
    }
}