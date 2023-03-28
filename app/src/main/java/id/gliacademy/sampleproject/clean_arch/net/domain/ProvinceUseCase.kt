package id.gliacademy.sampleproject.clean_arch.net.domain

import kotlinx.coroutines.flow.Flow

interface ProvinceUseCase {
  suspend fun getProvinces(): Flow<ProvinceEntity>
}