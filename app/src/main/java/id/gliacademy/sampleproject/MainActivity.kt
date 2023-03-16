package id.gliacademy.sampleproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.gliacademy.sampleproject.api.ApiActivity
import id.gliacademy.sampleproject.databinding.ActivityMainBinding
import id.gliacademy.sampleproject.livedata.LiveDataActivity
import id.gliacademy.sampleproject.viewmodel.ViewModelActivity
import id.gliacademy.sampleproject.viewmodel.WithoutViewModelActivity

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setupListener()
  }

  private fun setupListener() {
    binding.run {
      btnWithoutViewModel.setOnClickListener {
        startActivity(WithoutViewModelActivity.newIntent(this@MainActivity))
      }

      btnViewModel.setOnClickListener {
        startActivity(ViewModelActivity.newIntent(this@MainActivity))
      }

      btnLiveData.setOnClickListener {
        startActivity(LiveDataActivity.newIntent(this@MainActivity))
      }

      btnApi.setOnClickListener {
        startActivity(ApiActivity.newIntent(this@MainActivity))
      }

      btnApi2.setOnClickListener {
        startActivity(id.gliacademy.sampleproject.api_arch.view.ApiActivity.newIntent(this@MainActivity))
      }
    }
  }

}