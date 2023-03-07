package id.gliacademy.sampleproject

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.core.content.ContextCompat.startActivity

object Util {

  fun Context.dial(phoneNumber: String) {
    val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
    startActivity(dialPhoneIntent)
  }

  fun Context.gotoSetting() {
    startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
  }
}