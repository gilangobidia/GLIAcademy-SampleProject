package id.gliacademy.sampleproject.fragment

import android.os.Bundle
import android.text.TextUtils.replace
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import id.gliacademy.sampleproject.R

class MainFragmentActivity: AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main_fragment)
    setupFragment()
  }

  private fun setupFragment() {
    val fragment = AFragment()
    val fragmentManager = supportFragmentManager
    fragmentManager.beginTransaction().apply {
      replace(R.id.container, fragment, AFragment::class.java.simpleName)
      commit()
    }
  }
}