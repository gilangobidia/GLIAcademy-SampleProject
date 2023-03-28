package id.gliacademy.sampleproject.clean_arch.simple.data

data class StudentDataModel(
  val firstName: String?,
  val lastName: String?
) {

  companion object {
    fun createDummyStudent(): StudentDataModel {
      return StudentDataModel(
        "Android", "Studio"
      )
    }
  }
}