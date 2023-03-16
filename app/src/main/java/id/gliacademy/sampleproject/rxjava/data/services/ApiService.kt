package id.gliacademy.sampleproject.rxjava.data.services

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
  @GET("provinsi")
  fun getProvince(): Observable<ProvinceResponse>
}