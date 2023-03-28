package id.gliacademy.sampleproject.clean_arch.simple.domain

class StudentUseCaseImpl(val repository: StudentRepository): StudentUseCase {

  override fun getStudent(): StudentEntity {
    return repository.getStudent()
  }
}