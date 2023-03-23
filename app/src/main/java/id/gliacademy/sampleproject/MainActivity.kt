package id.gliacademy.sampleproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.gliacademy.sampleproject.databinding.ActivityMainBinding
import id.gliacademy.sampleproject.room.basic.BasicRoomActivity
import id.gliacademy.sampleproject.sharedpreferences.SharedPreferencesActivity

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
      btnSharedpreferences.setOnClickListener {
        startActivity(SharedPreferencesActivity.newIntent(this@MainActivity))
      }

      btnRoom.setOnClickListener {
        startActivity(BasicRoomActivity.newIntent(this@MainActivity))
      }
    }
  }

}