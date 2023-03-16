package id.gliacademy.sampleproject.rxjava.repository

import id.gliacademy.sampleproject.rxjava.data.services.Province

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