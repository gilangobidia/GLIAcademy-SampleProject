package id.gliacademy.sampleproject.clean_arch.net.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceEntity
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceUseCase
import kotlinx.coroutines.launch

class ProvinceViewModel(private val useCase: ProvinceUseCase): ViewModel() {

  private var _provinces = MutableLiveData<ProvinceEntity>()
  val provinces: LiveData<ProvinceEntity> = _provinces

  fun getProvinces() {
    _provinces.postValue(ProvinceEntity(ProvinceEntity.STATE_LOADING, arrayListOf()))
    viewModelScope.launch {
      useCase.getProvinces().collect {
          _provinces.postValue(it)
        }
    }
  }
}