package id.gliacademy.sampleproject.clean_arch.net.di

import id.gliacademy.sampleproject.clean_arch.net.data.repository.ProvinceRepositoryImpl
import id.gliacademy.sampleproject.clean_arch.net.data.repository.network.services.ApiConfig
import id.gliacademy.sampleproject.clean_arch.net.data.repository.network.services.ApiService
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceRepository
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceUseCase
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceUseCaseImpl

object Injection {

  fun provideUseCase(): ProvinceUseCase {
    val prrovinceRepository = provideRepository()
    return ProvinceUseCaseImpl(prrovinceRepository)
  }

  private fun provideRepository(): ProvinceRepository {
    val prrovinceApiService = provideApiService()
    return ProvinceRepositoryImpl(prrovinceApiService)
  }

  private fun provideApiService(): ApiService {
    return ApiConfig.getApiService()
  }
}