package id.gliacademy.sampleproject.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
  @GET("provinsi")
  fun getProvince(): Call<ProvinceResponse>
}