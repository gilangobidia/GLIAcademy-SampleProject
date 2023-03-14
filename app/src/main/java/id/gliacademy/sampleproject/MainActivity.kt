package id.gliacademy.sampleproject

import android.app.DatePickerDialog
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
import id.gliacademy.sampleproject.alertdialog.AlertDialogActivity
import id.gliacademy.sampleproject.bottomsheet.BottomSheetActivity
import id.gliacademy.sampleproject.snackbar.SnackbarActivity
import id.gliacademy.sampleproject.toast.ToastActivity
import id.gliacademy.sampleproject.viewbinding.ViewBindingActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {

  private lateinit var btnToast: Button
  private lateinit var btnSnackBar: Button
  private lateinit var btnBottomSheet: Button
  private lateinit var btnAlertDialog: Button
  private lateinit var btnViewBinding: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    setupView()
    setupListener()
  }

  private fun setupView() {
    btnToast = findViewById(R.id.btn_toast)
    btnSnackBar = findViewById(R.id.btn_snackbar)
    btnBottomSheet = findViewById(R.id.btn_bottom_sheet)
    btnAlertDialog = findViewById(R.id.btn_alert_dialog)
    btnViewBinding = findViewById(R.id.btn_view_binding)
  }

  private fun setupListener() {
    btnToast.setOnClickListener {
      startActivity(ToastActivity.newIntent(this))
    }

    btnSnackBar.setOnClickListener {
      startActivity(SnackbarActivity.newIntent(this))
    }

    btnBottomSheet.setOnClickListener {
      startActivity(BottomSheetActivity.newIntent(this))
    }

    btnAlertDialog.setOnClickListener {
      startActivity(AlertDialogActivity.newIntent(this))
    }

    btnViewBinding.setOnClickListener {
      startActivity(ViewBindingActivity.newIntent(this))
    }
  }

}