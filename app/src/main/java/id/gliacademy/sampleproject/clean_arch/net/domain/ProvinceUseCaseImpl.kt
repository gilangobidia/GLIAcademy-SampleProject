package id.gliacademy.sampleproject.clean_arch.net.domain

import androidx.paging.PagingData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProvinceUseCaseImpl @Inject constructor(private val repository: ProvinceRepository) :
  ProvinceUseCase {

  override suspend fun getProvinces(): Flow<ProvinceEntity> {
    return repository.getProvinces()
  }
  override suspend fun getProvinces(scope: CoroutineScope): Flow<PagingData<ProvinceItemModel>>{
    return repository.getProvinces(scope)
  }
}