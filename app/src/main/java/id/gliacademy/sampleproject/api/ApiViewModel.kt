package id.gliacademy.sampleproject.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiViewModel : ViewModel() {

  private val _provinces = MutableLiveData<List<Province>>()
  val provinces: LiveData<List<Province>> = _provinces

  private val _isLoading = MutableLiveData<Boolean>()
  val isLoading: LiveData<Boolean> = _isLoading

  init {
    getProvinces()
  }

  private fun getProvinces() {
    _isLoading.value = true
    val client = ApiConfig.getApiService().getProvince()
    client.enqueue(object : Callback<ProvinceResponse> {
      override fun onResponse(
        call: Call<ProvinceResponse>,
        response: Response<ProvinceResponse>
      ) {
        _isLoading.value = false
        if (response.isSuccessful) {
          _provinces.value = response.body()?.province
        } else {
          Log.e("TAG", "onFailure: ${response.message()}")
        }
      }

      override fun onFailure(call: Call<ProvinceResponse>, t: Throwable) {
        _isLoading.value = false
        Log.e("TAG", "onFailure: ${t.message.toString()}")
      }
    })
  }
}