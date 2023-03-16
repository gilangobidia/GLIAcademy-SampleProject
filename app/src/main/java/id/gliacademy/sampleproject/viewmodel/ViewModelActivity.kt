package id.gliacademy.sampleproject.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import id.gliacademy.sampleproject.databinding.ActivityViewmodelBinding

class ViewModelActivity: AppCompatActivity() {
  private lateinit var binding: ActivityViewmodelBinding

  private lateinit var viewModel: MyViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityViewmodelBinding.inflate(layoutInflater)
    setContentView(binding.root)

    viewModel = ViewModelProvider(this)[MyViewModel::class.java]

    setupListener()

    displayResult()
  }

  private fun setupListener() {
    binding.run {
      btnCalculate.setOnClickListener {
        val width = edtWidth.text.toString()
        val height = edtHeight.text.toString()
        val length = edtLength.text.toString()
        when {
          width.isEmpty() -> {
            edtWidth.error = "Masih kosong"
          }
          height.isEmpty() -> {
            edtHeight.error = "Masih kosong"
          }
          length.isEmpty() -> {
            edtLength.error = "Masih kosong"
          }
          else -> {
            viewModel.calculate(width, height, length)
            displayResult()
          }
        }
      }
    }
  }

  private fun displayResult() {
    binding.tvResult.text = viewModel.result.toString()
  }

  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, ViewModelActivity::class.java)
    }
  }
}