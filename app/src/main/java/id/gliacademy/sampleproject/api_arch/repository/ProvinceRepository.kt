package id.gliacademy.sampleproject.api_arch.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.gliacademy.sampleproject.api_arch.data.services.ApiConfig
import id.gliacademy.sampleproject.api_arch.data.services.ProvinceResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinceRepository {

  val model = MutableLiveData<ProvinceRepositoryModel>()

  fun getProvinces(): LiveData<ProvinceRepositoryModel> {
    model.value = ProvinceRepositoryModel(
      isLoading = true,
      state = ProvinceRepositoryModel.STATE_LOADING
    )

    val client = ApiConfig.getApiService().getProvince()

    client.enqueue(object : Callback<ProvinceResponse> {
      override fun onResponse(
        call: Call<ProvinceResponse>,
        response: Response<ProvinceResponse>
      ) {
        model.value = ProvinceRepositoryModel(
          isLoading = false
        )

        if (response.isSuccessful) {
          model.value = ProvinceRepositoryModel(
            provinces = response.body()?.province ?: arrayListOf(),
            isLoading = false
          )
        } else {
          model.value = ProvinceRepositoryModel(
            provinces = response.body()?.province ?: arrayListOf(),
            isLoading = false,
            error = response.message()
          )
          Log.e("TAG", "onFailure: ${response.message()}")
        }
      }

      override fun onFailure(call: Call<ProvinceResponse>, t: Throwable) {
        model.value = ProvinceRepositoryModel(
          isLoading = false
        )
        Log.e("TAG", "onFailure: ${t.message.toString()}")
      }
    })
    return model
  }
}