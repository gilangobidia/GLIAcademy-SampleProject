package id.gliacademy.sampleproject.clean_arch.net.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import id.gliacademy.sampleproject.clean_arch.net.data.repository.network.services.ApiService
import id.gliacademy.sampleproject.clean_arch.net.data.repository.network.services.MoviesListPagingSource
import id.gliacademy.sampleproject.clean_arch.net.data.repository.network.services.Province
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceEntity
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceEntity.Companion.STATE_ERROR
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceEntity.Companion.STATE_SUCCESS
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceItemModel
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ProvinceRepositoryImpl @Inject constructor(private val apiService: ApiService) :
  ProvinceRepository {

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

  override suspend fun getProvinces(scope: CoroutineScope): Flow<PagingData<ProvinceItemModel>> {
    return Pager(config = PagingConfig(10)) {
      MoviesListPagingSource(apiService)
    }.flow.cachedIn(scope)
  }
}