package id.gliacademy.sampleproject.clean_arch.simple.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.gliacademy.sampleproject.clean_arch.simple.domain.StudentEntity
import id.gliacademy.sampleproject.clean_arch.simple.domain.StudentUseCase

class StudentViewModel(private val useCase: StudentUseCase) : ViewModel() {
  private val _student = MutableLiveData<StudentEntity>()

  val student: LiveData<StudentEntity> get() = _student

  fun getStudent() {
    _student.value = useCase.getStudent()
  }
}