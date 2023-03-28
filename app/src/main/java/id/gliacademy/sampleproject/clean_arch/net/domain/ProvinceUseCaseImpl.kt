package id.gliacademy.sampleproject.clean_arch.net.domain

import kotlinx.coroutines.flow.Flow

class ProvinceUseCaseImpl(private val repository: ProvinceRepository): ProvinceUseCase {

  override suspend fun getProvinces(): Flow<ProvinceEntity> {
    return repository.getProvinces()
  }
}