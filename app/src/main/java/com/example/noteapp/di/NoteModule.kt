package com.example.noteapp.di

import android.content.Context
import androidx.room.Room
import com.example.noteapp.data.localdb.NoteDao
import com.example.noteapp.data.localdb.NoteDataBase
import com.example.noteapp.data.repository.NoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(
        @ApplicationContext context: Context
    ):NoteDataBase=
        Room.databaseBuilder(
            context,
            NoteDataBase::class.java,
            "note_db"
        ).allowMainThreadQueries()
            .build()

    @Singleton
    @Provides
    fun provideNoteDao(noteDataBase: NoteDataBase)=noteDataBase.noteDao()

    @Provides
    fun provideRepository(noteDao: NoteDao)= NoteRepositoryImpl(noteDao)

}
