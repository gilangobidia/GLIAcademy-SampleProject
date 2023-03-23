package id.gliacademy.sampleproject.room.basic.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(note: Note)

  @Update
  fun update(note: Note)

  @Delete
  fun delete(note: Note)

  @Query("DELETE FROM note WHERE id=:id")
  fun delete2(id: Int): LiveData<List<Note>>

  @Query("SELECT * from note ORDER BY id ASC")
  fun getAllNotes(): LiveData<List<Note>>
}