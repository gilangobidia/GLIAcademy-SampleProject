package id.gliacademy.sampleproject

class MainModel {

  var fullName: String = ""
  var email: String = ""
  var gender: Int? = null
  var dob: String = ""
  var address: String = ""
  var lastEducationId: Int = 0
  var lastEducation: String = ""


  val GENDER_MALE = 1
  val GENDER_FEMALE = 0

  val MIN_FULL_NAME_LENGTH = 6
  val MAX_FULL_NAME_LENGTH = 40
}