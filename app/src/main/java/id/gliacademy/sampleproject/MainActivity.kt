package id.gliacademy.sampleproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.gliacademy.sampleproject.clean_arch.net.presentation.NetworkActivity
import id.gliacademy.sampleproject.clean_arch.simple.presentation.SimpleActivity
import id.gliacademy.sampleproject.databinding.ActivityMainBinding

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
      btnCleanArchSimple.setOnClickListener {
        startActivity(SimpleActivity.newIntent(this@MainActivity))
      }

      btnCleanArchNetwork.setOnClickListener {
        startActivity(NetworkActivity.newIntent(this@MainActivity))
      }
    }
  }

}