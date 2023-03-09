package id.gliacademy.sampleproject.bottomnav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.gliacademy.sampleproject.R
import id.gliacademy.sampleproject.fragment.AFragment
import id.gliacademy.sampleproject.fragment.BFragment
import id.gliacademy.sampleproject.fragment.CFragment

class BottomNavigationActivity: AppCompatActivity() {

  private lateinit var navView: BottomNavigationView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_bottom_nav)

    navView = findViewById(R.id.nav_view)

    setupHome()

    navView.setOnItemSelectedListener {
      when (it.itemId) {
        R.id.nav_home -> setupHome()
        R.id.nav_cart -> setupCart()
        R.id.nav_account -> setupAccount()
      }

      true
    }
  }

  private fun setupHome() {
    val fragment = AFragment()
    val fragmentManager = supportFragmentManager
    fragmentManager.beginTransaction().apply {
      replace(R.id.container, fragment, AFragment::class.java.simpleName)
      commit()
    }
  }

  private fun setupCart() {
    val fragment = BFragment()
    val fragmentManager = supportFragmentManager
    fragmentManager.beginTransaction().apply {
      replace(R.id.container, fragment, BFragment::class.java.simpleName)
      commit()
    }
  }

  private fun setupAccount() {
    val fragment = CFragment()
    val fragmentManager = supportFragmentManager
    fragmentManager.beginTransaction().apply {
      replace(R.id.container, fragment, CFragment::class.java.simpleName)
      commit()
    }
  }
}