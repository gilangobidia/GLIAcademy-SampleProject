package id.gliacademy.sampleproject.sharedpreferences

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.gliacademy.sampleproject.databinding.ActivitySharedPreferencesBinding
import id.gliacademy.sampleproject.sharedpreferences.basic.BasicSPActivity
import id.gliacademy.sampleproject.sharedpreferences.encrypted.EncryptedSPActivity
import id.gliacademy.sampleproject.sharedpreferences.get_data.GetDataSPActivity

class SharedPreferencesActivity: AppCompatActivity() {


  private lateinit var binding: ActivitySharedPreferencesBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivitySharedPreferencesBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setupListener()
  }

  private fun setupListener() {
    binding.run {
      btnSharedpreferences.setOnClickListener {
        startActivity(BasicSPActivity.newIntent(this@SharedPreferencesActivity))
      }

      btnGetSharedpreferences.setOnClickListener {
        startActivity(GetDataSPActivity.newIntent(this@SharedPreferencesActivity))
      }

      btnEncryptedSharedpreferences.setOnClickListener {
        startActivity(EncryptedSPActivity.newIntent(this@SharedPreferencesActivity))
      }
    }
  }

  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, SharedPreferencesActivity::class.java)
    }
  }
}