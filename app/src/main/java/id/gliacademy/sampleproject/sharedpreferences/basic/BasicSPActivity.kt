package id.gliacademy.sampleproject.sharedpreferences.basic

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.gliacademy.sampleproject.databinding.ActivityBasicSharedPreferencesBinding

class BasicSPActivity: AppCompatActivity() {

  private lateinit var binding: ActivityBasicSharedPreferencesBinding

  private lateinit var pref: SharedPreferences

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityBasicSharedPreferencesBinding.inflate(layoutInflater)
    setContentView(binding.root)

    pref = getSharedPreferences("SAVE_DATA", Context.MODE_PRIVATE)

    setupListener()

    getData()
  }

  private fun getData() {
    binding.tvResult.text = pref.getString("result", null)
  }

  private fun saveData() {
    val editor = pref.edit()
    editor.putString("result", binding.etInput.text.toString())
    editor.apply()
  }

  private fun setupListener() {
    binding.run {
      btnSave.setOnClickListener {
        saveData()
        getData()
      }
    }
  }

  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, BasicSPActivity::class.java)
    }
  }
}