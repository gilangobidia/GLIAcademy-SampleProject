package id.gliacademy.sampleproject.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import id.gliacademy.sampleproject.databinding.ActivityViewmodelBinding

class WithoutViewModelActivity: AppCompatActivity() {
  private lateinit var binding: ActivityViewmodelBinding

  private var result: Int = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityViewmodelBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setupListener()

    displayResult()
    Log.d(TAG, "onCreate")
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
            calculate(width, height, length)
            displayResult()
          }
        }
      }
    }
  }

  private fun calculate(width: String, height: String, length: String) {
    result = width.toInt() * height.toInt() * length.toInt()
  }

  private fun displayResult() {
    binding.tvResult.text = result.toString()
  }

  override fun onStart() {
    super.onStart()
    Log.d(TAG, "onStart")
  }

  override fun onRestart() {
    super.onRestart()
    Log.d(TAG, "onRestart")
  }

  override fun onResume() {
    super.onResume()

    Log.d(TAG, "onResume")
  }
  companion object {
     val TAG = WithoutViewModelActivity::class.java.simpleName
    fun newIntent(context: Context): Intent {
      return Intent(context, WithoutViewModelActivity::class.java)
    }
  }
}