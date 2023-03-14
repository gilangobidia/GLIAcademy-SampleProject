package id.gliacademy.sampleproject.bottomsheet

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import id.gliacademy.sampleproject.R
import id.gliacademy.sampleproject.fragment.argument.DetailFragment


class BottomSheetActivity : AppCompatActivity() {

  private lateinit var btnBottomSheet1: Button
  private lateinit var btnBottomSheet2: Button

//  private lateinit var container: LinearLayout
  private lateinit var container: CoordinatorLayout

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(id.gliacademy.sampleproject.R.layout.activity_bottomsheet)

    setupView()
    setupListener()
  }

  private fun setupView() {
    btnBottomSheet1 = findViewById(id.gliacademy.sampleproject.R.id.btn_bottomsheet_1)
    btnBottomSheet2 = findViewById(id.gliacademy.sampleproject.R.id.btn_bottomsheet_2)

    container = findViewById(id.gliacademy.sampleproject.R.id.container)
  }

  private fun setupListener() {
    btnBottomSheet1.setOnClickListener {
      onBottomSheet1Clicked()
    }

    btnBottomSheet2.setOnClickListener {
      onBottomSheet2Clicked()
    }
  }

  private fun onBottomSheet1Clicked() {
    val bottomSheetDialog = BottomSheetDialog(this)
    bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog)

    val btnToast = bottomSheetDialog.findViewById<Button>(R.id.btn_toast)
    btnToast?.setOnClickListener {
      Toast.makeText(this@BottomSheetActivity, "Show", Toast.LENGTH_SHORT).show()
    }

    bottomSheetDialog.show()
  }

  private fun onBottomSheet2Clicked() {
    val bottomSheetDialogFragment = DetailFragment()
    bottomSheetDialogFragment.show(supportFragmentManager, "bottomSheetDialogFragment")
  }


  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, BottomSheetActivity::class.java)
    }
  }

}