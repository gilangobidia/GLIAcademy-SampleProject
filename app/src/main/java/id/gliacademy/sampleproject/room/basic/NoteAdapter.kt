package id.gliacademy.sampleproject.room.basic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.gliacademy.sampleproject.databinding.ItemNoteBinding
import id.gliacademy.sampleproject.room.basic.NoteAdapter.NoteViewHolder
import id.gliacademy.sampleproject.room.basic.db.Note

class NoteAdapter: RecyclerView.Adapter<NoteViewHolder>() {

  val list = arrayListOf<Note>()
  var deleteItemClickListener: ((note: Note, position: Int) -> Unit)? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
    val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return NoteViewHolder(binding)
  }

  override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
    holder.bind(list[position], position)
  }

  override fun getItemCount(): Int {
    return list.size
  }

  fun updateData(notes: List<Note>) {
    list.run {
      clear()
      addAll(notes)
    }
    notifyItemRangeChanged(0, list.size)
  }

  inner class NoteViewHolder(private val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(note: Note, position: Int) {
      with(binding) {
        tvTitle.text = note.title
        tvDesc.text = note.description
        btnDelete.setOnClickListener {
          deleteItemClickListener?.invoke(note, position)
        }
      }
    }
  }

}