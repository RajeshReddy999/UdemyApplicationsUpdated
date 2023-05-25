package com.rajesh.noteapp.screens


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rajesh.noteapp.data.NotesDataSource
import com.rajesh.noteapp.model.Note
import com.rajesh.noteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NoteViewModel @Inject constructor(val repository: NoteRepository) : ViewModel() {
    //private var noteList = mutableStateListOf<Note>()
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()


    init {
        //noteList.addAll(NotesDataSource().loadNotes())
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged().collect { listOfNotes ->
                if (listOfNotes.isNullOrEmpty()){
                    Log.d("Empty", ": Empty List ")
                } else{
                    _noteList.value = listOfNotes
                }
            }
        }
    }

    fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }
    fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }
    fun removeNote(note: Note) = viewModelScope.launch { repository.deleteNote(note) }
    fun addAllNotes() = viewModelScope.launch { repository.getAllNotes() }

}

