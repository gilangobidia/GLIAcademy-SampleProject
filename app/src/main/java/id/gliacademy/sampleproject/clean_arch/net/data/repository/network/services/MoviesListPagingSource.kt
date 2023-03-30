package id.gliacademy.sampleproject.clean_arch.net.data.repository.network.services

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.google.gson.Gson
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceItemModel

/**
 * Created by alfacart on 29/06/22.
 */

class MoviesListPagingSource(
  private val remoteDataSource: ApiService
) : PagingSource<Int, ProvinceItemModel>() {

  override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProvinceItemModel> {
    val position = params.key ?: 1
    return try {
      val response = remoteDataSource.getProvinces(
        start = if (position == 1) 0 else position * 10 - 10,
        limit = 10
      )
      val data =  Province.transforms(response.province ?: arrayListOf())
      Log.i("TAG", "load: " + Gson().toJson(data))
      toLoadResult(
        data = data,
        nextKey = if (data.isEmpty()) null else position + 1
      )

    } catch (e: Exception) {
      LoadResult.Error(e)
    }
  }
  override fun getRefreshKey(state: PagingState<Int, ProvinceItemModel>): Int? {
    return null
  }

  private fun toLoadResult(
    data: List<ProvinceItemModel>,
    prevKey: Int? = null,
    nextKey: Int? = null
  ): LoadResult<Int, ProvinceItemModel> {
    return LoadResult.Page(
      data = data,
      prevKey = prevKey,
      nextKey = nextKey
    )
  }
}
