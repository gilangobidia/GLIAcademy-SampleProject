package id.gliacademy.sampleproject.clean_arch.simple.di

import id.gliacademy.sampleproject.clean_arch.simple.data.StudentDataSource
import id.gliacademy.sampleproject.clean_arch.simple.data.StudentRepositoryImpl
import id.gliacademy.sampleproject.clean_arch.simple.domain.StudentRepository
import id.gliacademy.sampleproject.clean_arch.simple.domain.StudentUseCase
import id.gliacademy.sampleproject.clean_arch.simple.domain.StudentUseCaseImpl

object Injection {
  fun provideUseCase(): StudentUseCase {
    val studentRepository = provideRepository()
    return StudentUseCaseImpl(studentRepository)
  }

  private fun provideRepository(): StudentRepository {
    val studentDataSource = provideDataSource()
    return StudentRepositoryImpl(studentDataSource)
  }

  private fun provideDataSource(): StudentDataSource {
    return StudentDataSource()
  }
}