package id.gliacademy.sampleproject.clean_arch.net.data.repository.di

import dagger.Module
import dagger.Provides
import id.gliacademy.sampleproject.clean_arch.net.data.repository.network.services.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
  @Provides
  fun getApiService(): ApiService {
    val loggingInterceptor =
      HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder()
      .addInterceptor(loggingInterceptor)
      .build()
    val retrofit = Retrofit.Builder()
      .baseUrl("https://dev.farizdotid.com/api/daerahindonesia/")
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .client(client)
      .build()
    return retrofit.create(ApiService::class.java)
  }
}