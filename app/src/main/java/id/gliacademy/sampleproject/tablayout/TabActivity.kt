package id.gliacademy.sampleproject.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.Tab
import id.gliacademy.sampleproject.R
import id.gliacademy.sampleproject.fragment.AFragment
import id.gliacademy.sampleproject.fragment.BFragment
import id.gliacademy.sampleproject.fragment.nested.MainFragment


class TabActivity: AppCompatActivity() {
  private lateinit var tabLayout: TabLayout

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_tab)
    setupView()
    setupTab()

    setupFragment(0)
  }

  private fun setupView() {
    tabLayout = findViewById(R.id.tab_layout)
  }

  private fun setupTab() {
    tabLayout.addTab(
      tabLayout.newTab().setText("Fragment A")
    )

    tabLayout.addTab(
      tabLayout.newTab().setText("Fragment B")
    )

    tabLayout.addTab(
      tabLayout.newTab().setText("Fragment C")
    )
    tabLayout.addTab(
      tabLayout.newTab().setText("Fragment D")
    )
    tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
      override fun onTabReselected(tab: Tab) {
      }

      override fun onTabUnselected(tab: Tab) {
      }

      override fun onTabSelected(tab: Tab) {
        setupFragment(tab.position)
      }
    })
  }

  private fun setupFragment(position: Int) {
    val fragment = if (position == 0) AFragment() else BFragment()
    val tag = if (position == 0) AFragment::class.java.simpleName else BFragment::class.java.simpleName
    val fragmentManager = supportFragmentManager
    fragmentManager.beginTransaction().apply {
      replace(R.id.container, fragment, tag)
      commit()
    }
  }

}