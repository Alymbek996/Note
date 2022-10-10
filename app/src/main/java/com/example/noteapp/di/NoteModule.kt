package com.example.noteapp.di

import android.content.Context
import androidx.room.Room
import com.example.noteapp.data.localdb.NoteDao
import com.example.noteapp.data.localdb.NoteDataBase
import com.example.noteapp.data.repository.NoteRepositoryImpl
import com.example.noteapp.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.DefineComponent
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.Multibinds
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(
        @ApplicationContext context: Context
    ): NoteDataBase = Room.databaseBuilder(
        context,
        NoteDataBase::class.java,
        "note_db"
    ).allowMainThreadQueries()
        .build()


    @Singleton
    @Provides
    fun provideNoteDao(noteDataBase: NoteDataBase) : NoteDao = noteDataBase.noteDao()

    @Provides
   fun provideNoteRepository(noteDao: NoteDao):NoteRepository = NoteRepositoryImpl(noteDao)

}
//@InstallIn(SingletonComponent::class)
//@Module
//abstract class Module{
//    @Singleton
//    @Binds
//    abstract fun bindDependency(noteRepositoryImpl: NoteRepositoryImpl):NoteRepository
//
//}