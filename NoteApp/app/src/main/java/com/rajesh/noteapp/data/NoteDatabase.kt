package com.rajesh.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rajesh.noteapp.model.Note
import com.rajesh.noteapp.util.DateConverter
import com.rajesh.noteapp.util.UUUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = true)
@TypeConverters(DateConverter::class,UUUIDConverter::class)
abstract class NoteDatabase:RoomDatabase() {
    abstract fun noteDao():NoteDatabaseDao
}
