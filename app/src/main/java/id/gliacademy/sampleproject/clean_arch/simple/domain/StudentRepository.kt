package id.gliacademy.sampleproject.clean_arch.simple.domain

interface StudentRepository {
  fun getStudent(): StudentEntity
}