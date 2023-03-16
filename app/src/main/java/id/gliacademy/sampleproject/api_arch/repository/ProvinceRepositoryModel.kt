package id.gliacademy.sampleproject.api_arch.repository

import id.gliacademy.sampleproject.api_arch.data.services.Province

class ProvinceRepositoryModel(
  var provinces: List<Province> = arrayListOf(),
  var isLoading: Boolean = false,
  var error: String = "",
  var state: Int = STATE_LOADING
) {

  companion object {
    const val STATE_LOADING = 0
    const val STATE_DATA = 1
  }

}