package id.gliacademy.sampleproject.api_arch.repository

import androidx.lifecycle.MutableLiveData
import id.gliacademy.sampleproject.api_arch.data.services.ApiConfig
import id.gliacademy.sampleproject.api_arch.data.services.ProvinceResponse
import retrofit2.Call

class ProvinceRepository {

  val model = MutableLiveData<ProvinceRepositoryModel>()

  fun getProvinces(): Call<ProvinceResponse> {
    return ApiConfig.getApiService().getProvince()
  }
}