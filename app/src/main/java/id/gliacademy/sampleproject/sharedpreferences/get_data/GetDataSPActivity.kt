package id.gliacademy.sampleproject.sharedpreferences.get_data

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.gliacademy.sampleproject.databinding.ActivityGetSharedPreferencesBinding
import id.gliacademy.sampleproject.sharedpreferences.get_data.SharedPreferenceUtil.getSP


class GetDataSPActivity: AppCompatActivity() {

  private lateinit var binding: ActivityGetSharedPreferencesBinding

  private lateinit var pref: SharedPreferences

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityGetSharedPreferencesBinding.inflate(layoutInflater)
    setContentView(binding.root)

    pref = getSharedPreferences("SAVE_DATA", Context.MODE_PRIVATE)

    getData()
  }

  private fun getData() {
    binding.tvResult.text = getSP().getString("result", null)
  }

  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, GetDataSPActivity::class.java)
    }
  }
}