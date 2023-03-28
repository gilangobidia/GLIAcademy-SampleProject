package id.gliacademy.sampleproject.clean_arch.simple.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.gliacademy.sampleproject.clean_arch.simple.di.Injection
import id.gliacademy.sampleproject.clean_arch.simple.domain.StudentUseCase

class StudentViewModelFactory(
  private var useCase: StudentUseCase
) : ViewModelProvider.NewInstanceFactory() {

  companion object {
    @Volatile
    private var instance: StudentViewModelFactory? = null

    fun getInstance(): StudentViewModelFactory =
      instance ?: synchronized(this) {
        instance ?: StudentViewModelFactory(Injection.provideUseCase())
      }
  }

  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return when {
      modelClass.isAssignableFrom(StudentViewModel::class.java) -> StudentViewModel(useCase) as T
      else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
  }
}