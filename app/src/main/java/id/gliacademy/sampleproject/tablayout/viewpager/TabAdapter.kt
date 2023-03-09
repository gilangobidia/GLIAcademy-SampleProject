package id.gliacademy.sampleproject.tablayout.viewpager

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.gliacademy.sampleproject.fragment.AFragment
import id.gliacademy.sampleproject.fragment.BFragment
import id.gliacademy.sampleproject.fragment.CFragment

class TabAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

  override fun createFragment(position: Int): Fragment {
    var fragment: Fragment? = null
    when (position) {
      0 -> fragment = CFragment()
      1 -> fragment = BFragment()
    }
    return fragment as Fragment
  }

  override fun getItemCount(): Int {
    return 2
  }
}