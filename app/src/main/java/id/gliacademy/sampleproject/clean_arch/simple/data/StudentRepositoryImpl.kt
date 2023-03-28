package id.gliacademy.sampleproject.clean_arch.simple.data

import id.gliacademy.sampleproject.clean_arch.simple.domain.StudentEntity
import id.gliacademy.sampleproject.clean_arch.simple.domain.StudentRepository

class StudentRepositoryImpl(private val dataSource: StudentDataSource): StudentRepository {

  override fun getStudent(): StudentEntity {
    return dataSource.getStudentName()
  }
}