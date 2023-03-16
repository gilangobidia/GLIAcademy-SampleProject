package id.gliacademy.sampleproject.api_arch.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.gliacademy.sampleproject.api_arch.repository.ProvinceRepository
import id.gliacademy.sampleproject.api_arch.repository.ProvinceRepositoryModel

class ApiViewModel : ViewModel() {

  private val repository = ProvinceRepository()

  private var _provinceRepositoryModel = MutableLiveData<ProvinceRepositoryModel>()
//  val provinceRepositoryModel: LiveData<ProvinceRepositoryModel> = _provinceRepositoryModel

  init {
    getProvinces()
  }

  fun getProvinceRepositoryModel(): LiveData<ProvinceRepositoryModel> = _provinceRepositoryModel

  private fun getProvinces() {
    _provinceRepositoryModel = repository.getProvinces() as MutableLiveData<ProvinceRepositoryModel>
  }
}