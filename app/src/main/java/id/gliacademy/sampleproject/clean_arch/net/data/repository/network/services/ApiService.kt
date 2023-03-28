package id.gliacademy.sampleproject.clean_arch.net.data.repository.network.services

import retrofit2.http.GET

interface ApiService {
  @GET("provinsi")
  suspend fun getProvinces(): ProvinceResponse
}