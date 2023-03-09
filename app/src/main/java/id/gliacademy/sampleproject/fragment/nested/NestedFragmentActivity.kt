package id.gliacademy.sampleproject.fragment.nested

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.gliacademy.sampleproject.R
import id.gliacademy.sampleproject.fragment.AFragment

class NestedFragmentActivity: AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main_fragment)
    setupFragment()
  }

  private fun setupFragment() {
    val fragment = MainFragment()
    val fragmentManager = supportFragmentManager
    fragmentManager.beginTransaction().apply {
      replace(R.id.container, fragment, MainFragment::class.java.simpleName)
      commit()
    }
  }
}