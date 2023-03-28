package id.gliacademy.sampleproject.clean_arch.net.domain

data class ProvinceEntity(
  val state: Int,
  val data: List<ProvinceItemModel>
) {
  companion object {
    const val STATE_LOADING = 0
    const val STATE_SUCCESS = 1
    const val STATE_ERROR = 2
  }
}