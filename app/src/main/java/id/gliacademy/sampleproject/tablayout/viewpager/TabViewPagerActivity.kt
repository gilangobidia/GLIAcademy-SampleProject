package id.gliacademy.sampleproject.tablayout.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import id.gliacademy.sampleproject.R

class TabActivity: AppCompatActivity() {
  private lateinit var tabLayout: TabLayout
  private lateinit var viewPager: ViewPager2

  private val TAB_TITLES = arrayOf(
    "Fragment A",
    "Fragment B"
  )

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_tab_viewpager)
    setupView()
    setupTab()
  }

  private fun setupView() {
    tabLayout = findViewById(R.id.tab_layout)
    viewPager = findViewById(R.id.view_pager)
  }

  private fun setupTab() {
    val tabAdapter = TabAdapter(this)
    viewPager.adapter = tabAdapter
    TabLayoutMediator(tabLayout, viewPager) { tab, position ->
      tab.text = TAB_TITLES[position]
    }.attach()

  }

}