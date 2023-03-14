package id.gliacademy.sampleproject.fragment.argument

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import id.gliacademy.sampleproject.R
import id.gliacademy.sampleproject.databinding.FragmentDetailBinding
import java.util.zip.Inflater

class DetailFragment: BottomSheetDialogFragment() {
  private lateinit var binding: FragmentDetailBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentDetailBinding.inflate(inflater)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val string = arguments?.getString("hello")

    binding.tvPage.text = string
    binding.btnAction.setOnClickListener {
      Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show()
    }
  }
}