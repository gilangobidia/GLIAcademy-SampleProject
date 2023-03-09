package id.gliacademy.sampleproject.fragment.argument

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import id.gliacademy.sampleproject.R

class DetailFragment: Fragment() {

  private lateinit var tvPage: TextView

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_detail, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    tvPage = view.findViewById(R.id.tv_page)

    val string = arguments?.getString("hello")

    tvPage.text = string



  }
}