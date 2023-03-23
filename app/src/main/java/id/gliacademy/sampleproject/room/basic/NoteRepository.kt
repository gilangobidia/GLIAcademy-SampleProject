package id.gliacademy.sampleproject.room.basic

import android.app.Application
import androidx.lifecycle.LiveData
import id.gliacademy.sampleproject.room.basic.db.Note
import id.gliacademy.sampleproject.room.basic.db.NoteDao
import id.gliacademy.sampleproject.room.basic.db.NoteRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NoteRepository(application: Application) {
  private val mNotesDao: NoteDao
  private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

  init {
    val db = NoteRoomDatabase.getDatabase(application)
    mNotesDao = db.noteDao()
  }

  fun getAllNotes(): LiveData<List<Note>> = mNotesDao.getAllNotes()

  fun insert(note: Note) {
    executorService.execute { mNotesDao.insert(note) }
  }

  fun delete(note: Note) {
    executorService.execute { mNotesDao.delete(note) }
  }
}