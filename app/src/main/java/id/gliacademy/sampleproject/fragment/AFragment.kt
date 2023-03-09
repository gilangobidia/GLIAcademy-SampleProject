package id.gliacademy.sampleproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import id.gliacademy.sampleproject.R

class AFragment: Fragment() {

  private lateinit var btnAction: Button

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_a, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    btnAction = view.findViewById(R.id.btn_action)
    btnAction.setOnClickListener {
      Toast.makeText(requireContext(), "Fragment A", Toast.LENGTH_LONG).show()
    }
  }
}