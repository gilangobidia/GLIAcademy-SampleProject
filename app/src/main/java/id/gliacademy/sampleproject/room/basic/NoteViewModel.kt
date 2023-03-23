package id.gliacademy.sampleproject.room.basic

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.gliacademy.sampleproject.room.basic.db.Note

class NoteViewModel(application: Application) : ViewModel() {

  private val mNoteRepository: NoteRepository = NoteRepository(application)

  fun getAllNotes(): LiveData<List<Note>> = mNoteRepository.getAllNotes()

  fun insert(note: Note) {
    mNoteRepository.insert(note)
  }

  fun delete(note: Note) {
    mNoteRepository.delete(note)
  }

}