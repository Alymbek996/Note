package com.example.noteapp

import android.app.Application
import androidx.room.Room
import com.example.noteapp.data.localdb.NoteDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App:Application(){

    companion object{
        lateinit var database: NoteDataBase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, NoteDataBase::class.java,"database")
            .allowMainThreadQueries()
            .build()
    }
}