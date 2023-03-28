package id.gliacademy.sampleproject.clean_arch.simple.data

import id.gliacademy.sampleproject.clean_arch.simple.domain.StudentEntity

class StudentDataSource {

  fun getStudentName(): StudentEntity {
    val dummyStudent = StudentDataModel.createDummyStudent()

    return StudentEntity(
      dummyStudent.firstName + " " + dummyStudent.lastName
    )
  }
}