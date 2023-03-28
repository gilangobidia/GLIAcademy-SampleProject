package id.gliacademy.sampleproject.clean_arch.simple.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import id.gliacademy.sampleproject.databinding.ActivityCleanArchSimpleBinding

class SimpleActivity: AppCompatActivity() {

  private lateinit var binding: ActivityCleanArchSimpleBinding

  private lateinit var viewModel: StudentViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityCleanArchSimpleBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setupViewModel()
    setupObserve()

    viewModel.getStudent()
  }

  private fun setupViewModel() {
    val factory = StudentViewModelFactory.getInstance()
    viewModel = ViewModelProvider(this, factory)[StudentViewModel::class.java]
  }

  private fun setupObserve() {
    viewModel.student.observe(this) {
      binding.tvFullName.text = it.fullName
    }
  }

  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, SimpleActivity::class.java)
    }
  }
}