package id.gliacademy.sampleproject.api_arch.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.gliacademy.sampleproject.api_arch.data.services.ProvinceResponse
import id.gliacademy.sampleproject.api_arch.repository.ProvinceRepository
import id.gliacademy.sampleproject.api_arch.repository.ProvinceRepositoryModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiViewModel : ViewModel() {

  private val repository = ProvinceRepository()

  private var _provinceRepositoryModel = MutableLiveData<ProvinceRepositoryModel>()
//  val provinceRepositoryModel: LiveData<ProvinceRepositoryModel> = _provinceRepositoryModel

  init {
    getProvinces()
  }

  fun getProvinceRepositoryModel(): LiveData<ProvinceRepositoryModel> = _provinceRepositoryModel

  private fun getProvinces() {
    repository.getProvinces().enqueue(object : Callback<ProvinceResponse> {
    override fun onResponse(
      call: Call<ProvinceResponse>,
      response: Response<ProvinceResponse>
    ) {
      _provinceRepositoryModel.value = ProvinceRepositoryModel(
        isLoading = false
      )

      if (response.isSuccessful) {
        _provinceRepositoryModel.value = ProvinceRepositoryModel(
          provinces = response.body()?.province ?: arrayListOf(),
          isLoading = false
        )
      } else {
        _provinceRepositoryModel.value = ProvinceRepositoryModel(
          provinces = response.body()?.province ?: arrayListOf(),
          isLoading = false,
          error = response.message()
        )
        Log.e("TAG", "onFailure: ${response.message()}")
      }
    }

    override fun onFailure(call: Call<ProvinceResponse>, t: Throwable) {
      _provinceRepositoryModel.value = ProvinceRepositoryModel(
        isLoading = false
      )
      Log.e("TAG", "onFailure: ${t.message.toString()}")
    }
  })
  }
}