package id.gliacademy.sampleproject.clean_arch.net.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProvinceUseCaseImpl @Inject constructor(private val repository: ProvinceRepository) :
  ProvinceUseCase {

  override suspend fun getProvinces(): Flow<ProvinceEntity> {
    return repository.getProvinces()
  }
}