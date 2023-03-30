package id.gliacademy.sampleproject.clean_arch.net.data.repository.network.services

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
  @GET("provinsi")
  suspend fun getProvinces(): ProvinceResponse

  @GET("provinsi")
  suspend fun getProvinces(
    @Query("start") start: Int,
    @Query("limit") limit: Int
  ): ProvinceResponse
}