package id.gliacademy.sampleproject.api_arch.data.services

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
  @GET("provinsi")
  fun getProvince(): Call<ProvinceResponse>
}