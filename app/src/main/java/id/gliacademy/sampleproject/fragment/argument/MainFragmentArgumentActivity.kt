package id.gliacademy.sampleproject.fragment.argument

import android.os.Bundle
import android.text.TextUtils.replace
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import id.gliacademy.sampleproject.R
import id.gliacademy.sampleproject.fragment.AFragment

class MainFragmentArgumentActivity: AppCompatActivity() {
  private lateinit var btn: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main_fragment)
    btn = findViewById(R.id.btn_action)
    btn.setOnClickListener {
      setupDetailFragment()
    }
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

  private fun setupDetailFragment() {
    val fragment = DetailFragment()

    val bundle = Bundle()
    bundle.putString("hello", "Hello Fragment")
    bundle.putInt("number", 100)
    fragment.arguments = bundle
    val fragmentManager = supportFragmentManager
    fragmentManager.beginTransaction().apply {
      replace(R.id.container, fragment, DetailFragment::class.java.simpleName)
        .addToBackStack(null)
      commit()
    }
  }
}