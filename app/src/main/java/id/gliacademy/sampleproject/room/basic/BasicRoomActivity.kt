package id.gliacademy.sampleproject.room.basic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.gliacademy.sampleproject.databinding.ActivityBasicRoomBinding
import id.gliacademy.sampleproject.room.ViewModelFactory
import id.gliacademy.sampleproject.room.basic.db.Note

class BasicRoomActivity: AppCompatActivity() {

  private lateinit var binding: ActivityBasicRoomBinding

  private val adapter = NoteAdapter()

  private lateinit var viewModel: NoteViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityBasicRoomBinding.inflate(layoutInflater)
    setContentView(binding.root)

    viewModel = obtainViewModel(this)

    setupRecyclerViewNote()
    observeNotes()
  }

  private fun obtainViewModel(activity: AppCompatActivity): NoteViewModel {
    val factory = ViewModelFactory.getInstance(activity.application)
    return ViewModelProvider(activity, factory)[NoteViewModel::class.java]
  }

  private fun addNotes() {
    for (i in 1..10) {
      viewModel.insert(Note(title = "Title $i", description = "Desription $i"))
    }
  }

  private fun observeNotes() {
    viewModel.getAllNotes().observe(this) { noteList ->
      if (noteList != null) {
        adapter.updateData(noteList)
      }
    }
  }

  private fun setupRecyclerViewNote() {
    adapter.run {
      deleteItemClickListener = { note, position ->
      }
    }

    val layoutManager = LinearLayoutManager(this)
    binding.rvData.layoutManager = layoutManager
    binding.rvData.adapter = adapter
  }

  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, BasicRoomActivity::class.java)
    }
  }
}