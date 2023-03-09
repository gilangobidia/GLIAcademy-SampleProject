package id.gliacademy.sampleproject.fragment.nested

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.gliacademy.sampleproject.R
import id.gliacademy.sampleproject.fragment.AFragment
import id.gliacademy.sampleproject.fragment.BFragment
import id.gliacademy.sampleproject.fragment.CFragment
import id.gliacademy.sampleproject.fragment.DFragment

class MainFragment: Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_main, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupFragment()
  }


  private fun setupFragment() {
    val aFragment = AFragment()
    val aFragmentManager = childFragmentManager
    aFragmentManager.beginTransaction().apply {
      replace(R.id.container_a, aFragment, AFragment::class.java.simpleName)
      commit()
    }

    val bFragment = BFragment()
    val bFragmentManager = childFragmentManager
    bFragmentManager.beginTransaction().apply {
      replace(R.id.container_b, bFragment, BFragment::class.java.simpleName)
      commit()
    }

    val cFragment = CFragment()
    val cFragmentManager = childFragmentManager
    cFragmentManager.beginTransaction().apply {
      replace(R.id.container_c, cFragment, CFragment::class.java.simpleName)
      commit()
    }

    val dFragment = DFragment()
    val dFragmentManager = childFragmentManager
    dFragmentManager.beginTransaction().apply {
      replace(R.id.container_d, dFragment, DFragment::class.java.simpleName)
      commit()
    }
  }
}