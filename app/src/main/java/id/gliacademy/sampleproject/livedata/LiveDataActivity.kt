package id.gliacademy.sampleproject.livedata

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.gliacademy.sampleproject.R.string
import id.gliacademy.sampleproject.databinding.ActivityLiveDataBinding

class LiveDataActivity: AppCompatActivity() {
  private lateinit var binding: ActivityLiveDataBinding

  private lateinit var viewModel: LiveDataViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityLiveDataBinding.inflate(layoutInflater)
    setContentView(binding.root)

    viewModel = ViewModelProvider(this)[LiveDataViewModel::class.java]

    subscribe()
  }

  private fun subscribe() {
    val elapsedTimeObserver = Observer<Long?> { aLong ->
      val newText = this@LiveDataActivity.resources.getString(string.seconds, aLong)
      binding.timerTextview.text = newText
    }
    viewModel.getElapsedTime().observe(this, elapsedTimeObserver)
  }

  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, LiveDataActivity::class.java)
    }
  }
}