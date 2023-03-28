package id.gliacademy.sampleproject.clean_arch.net.domain

import kotlinx.coroutines.flow.Flow

interface ProvinceRepository {
  suspend fun getProvinces(): Flow<ProvinceEntity>
}