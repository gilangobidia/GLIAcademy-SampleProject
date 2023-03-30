package id.gliacademy.sampleproject.clean_arch.net.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceItemModel
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProvinceViewModel @Inject constructor(private val useCase: ProvinceUseCase) : ViewModel() {

  private var _provinces = MutableLiveData<PagingData<ProvinceItemModel>>()
  val provinces: LiveData<PagingData<ProvinceItemModel>> = _provinces

 /* fun getProvinces() {
    _provinces.postValue(ProvinceEntity(ProvinceEntity.STATE_LOADING, arrayListOf()))
    viewModelScope.launch {
      useCase.getProvinces(viewModelScope).collect {
        _provinces.postValue(it)
      }
    }
  }*/
 suspend fun getProvincess(): Flow<PagingData<ProvinceItemModel>> {
   return useCase
     .getProvinces(viewModelScope)
 }



}