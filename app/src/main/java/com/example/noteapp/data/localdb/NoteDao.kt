package com.example.noteapp.data.localdb

import androidx.room.*
import com.example.noteapp.data.model.NoteEntity

@Dao
interface NoteDao {

 @Insert(onConflict = OnConflictStrategy.REPLACE)
 suspend fun createNote(noteEntity: NoteEntity)

@Query("Select * from notes")
suspend fun getAllNotes():List<NoteEntity>

@Update
suspend fun edit(noteEntity: NoteEntity)

@Delete
suspend fun deleteNote(noteEntity: NoteEntity)

}