package id.gliacademy.sampleproject.viewbinding

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import androidx.core.content.ContextCompat
import id.gliacademy.sampleproject.R
import id.gliacademy.sampleproject.alertdialog.AlertDialogActivity
import id.gliacademy.sampleproject.bottomsheet.BottomSheetActivity
import id.gliacademy.sampleproject.databinding.ActivityMainBinding
import id.gliacademy.sampleproject.snackbar.SnackbarActivity
import id.gliacademy.sampleproject.toast.ToastActivity
import java.util.Calendar

class ViewBindingActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setupView()
    setupListener()
  }

  private fun setupView() {
  }

  private fun setupListener() {
    binding.btnToast.setOnClickListener {
        startActivity(ToastActivity.newIntent(this))
      }

    binding.btnSnackbar.setOnClickListener {
        startActivity(SnackbarActivity.newIntent(this))
      }

    binding.btnBottomSheet.setOnClickListener {
        startActivity(BottomSheetActivity.newIntent(this))
      }

    binding.btnAlertDialog.setOnClickListener {
        startActivity(AlertDialogActivity.newIntent(this))
      }

    binding.btnViewBinding.setOnClickListener {

      }
  }

  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, ViewBindingActivity::class.java)
    }
  }

}