package id.gliacademy.sampleproject.clean_arch.net.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceUseCase
import javax.inject.Inject

class ProvinceViewModelFactory @Inject constructor(
  private var useCase: ProvinceUseCase
) : ViewModelProvider.NewInstanceFactory() {

//  companion object {
//    @Volatile
//    private var instance: ProvinceViewModelFactory? = null
//
//    fun getInstance(): ProvinceViewModelFactory =
//      instance ?: synchronized(this) {
//        instance ?: ProvinceViewModelFactory(Injection.provideUseCase())
//      }
//  }

  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return when {
      modelClass.isAssignableFrom(ProvinceViewModel::class.java) -> ProvinceViewModel(useCase) as T
      else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
  }
}