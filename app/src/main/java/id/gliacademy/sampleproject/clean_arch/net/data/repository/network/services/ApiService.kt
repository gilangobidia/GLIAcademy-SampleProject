package id.gliacademy.sampleproject.clean_arch.net.data.repository.network.services

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
  @Headers("Content-Type: application/json")
  @GET("lara")
  suspend fun getProvinces(): List<Province>

  @GET("provinsi")
  suspend fun getProvinces(
    @Query("start") start: Int,
    @Query("limit") limit: Int
  ): ProvinceResponse
}