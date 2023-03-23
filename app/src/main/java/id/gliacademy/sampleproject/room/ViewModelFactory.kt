package id.gliacademy.sampleproject.room

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.gliacademy.sampleproject.room.basic.NoteViewModel

class ViewModelFactory private constructor(private val mApplication: Application) : ViewModelProvider.NewInstanceFactory() {
  companion object {
    @Volatile
    private var INSTANCE: ViewModelFactory? = null
    @JvmStatic
    fun getInstance(application: Application): ViewModelFactory {
      if (INSTANCE == null) {
        synchronized(ViewModelFactory::class.java) {
          INSTANCE = ViewModelFactory(application)
        }
      }
      return INSTANCE as ViewModelFactory
    }
  }

  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
      return NoteViewModel(mApplication) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
  }
}