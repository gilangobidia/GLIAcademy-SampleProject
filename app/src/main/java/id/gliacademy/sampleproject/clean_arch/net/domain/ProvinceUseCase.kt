package id.gliacademy.sampleproject.clean_arch.net.domain

import androidx.paging.PagingData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface ProvinceUseCase {
  suspend fun getProvinces(): Flow<ProvinceEntity>
  suspend fun getProvinces(scope: CoroutineScope): Flow<PagingData<ProvinceItemModel>>
}