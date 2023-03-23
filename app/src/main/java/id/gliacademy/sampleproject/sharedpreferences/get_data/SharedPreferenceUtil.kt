package id.gliacademy.sampleproject.sharedpreferences.get_data

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

object SharedPreferenceUtil {

  fun Context.getSP(): SharedPreferences {
    return getSharedPreferences("SAVE_DATA", Context.MODE_PRIVATE)
  }

  fun Context.getEncryptedSP(): SharedPreferences {

    val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    return EncryptedSharedPreferences.create(
      masterKeyAlias,
      "SAVE_DATA_2",
      this,
      EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
      EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

  }
}