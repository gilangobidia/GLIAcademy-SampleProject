package id.gliacademy.sampleproject.clean_arch.net.data.repository

import id.gliacademy.sampleproject.clean_arch.net.data.repository.network.services.ApiService
import id.gliacademy.sampleproject.clean_arch.net.data.repository.network.services.Province
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceEntity
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceEntity.Companion.STATE_ERROR
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceEntity.Companion.STATE_SUCCESS
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ProvinceRepositoryImpl(private val apiService: ApiService): ProvinceRepository {

  override suspend fun getProvinces(): Flow<ProvinceEntity> {
    return flow {
      try {
        val response = apiService.getProvinces()
        emit(ProvinceEntity(STATE_SUCCESS, Province.transforms(response.province ?: arrayListOf())))
      } catch (e: Throwable) {
        emit(ProvinceEntity(STATE_ERROR, arrayListOf()))
      }
    }.flowOn(Dispatchers.IO)
  }
}