package id.gliacademy.sampleproject.sharedpreferences.encrypted

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import id.gliacademy.sampleproject.databinding.ActivityBasicSharedPreferencesBinding

class EncryptedSPActivity: AppCompatActivity() {

  private lateinit var binding: ActivityBasicSharedPreferencesBinding

  private lateinit var pref: SharedPreferences

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityBasicSharedPreferencesBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    pref = EncryptedSharedPreferences.create(
      masterKeyAlias,
      "SAVE_DATA_2",
      this,
      EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
      EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    setupListener()
    getData()
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

  private fun getData() {
    binding.tvResult.text = pref.getString("result", null)
  }

  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, EncryptedSPActivity::class.java)
    }
  }
}