package id.gliacademy.sampleproject.snackbar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar
import id.gliacademy.sampleproject.R


class SnackbarActivity : AppCompatActivity() {

  private lateinit var btnSnackbar1: Button
  private lateinit var btnSnackbar2: Button

//  private lateinit var container: LinearLayout
  private lateinit var container: CoordinatorLayout

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_snackbar_2)

    setupView()
    setupListener()
  }

  private fun setupView() {
    btnSnackbar1 = findViewById(R.id.btn_snackbar_1)
    btnSnackbar2 = findViewById(R.id.btn_snackbar_2)

    container = findViewById(R.id.container)
  }

  private fun setupListener() {
    btnSnackbar1.setOnClickListener {
      onSnackbar1Clicked()
    }

    btnSnackbar2.setOnClickListener {
      onSnackbar2Clicked()
    }
  }

  private fun onSnackbar1Clicked() {
    val snackbar = Snackbar.make(container, "Snackbar 1", Snackbar.LENGTH_LONG)
    snackbar.show()
  }

  private fun onSnackbar2Clicked() {
    val snackbar = Snackbar
      .make(container, "Snackbar 2", Snackbar.LENGTH_LONG)
      .setAction("Click") {
        val snackbar1 =
          Snackbar.make(container, "Snackbar Clicked", Snackbar.LENGTH_SHORT)
        snackbar1.show()
      }

    snackbar.show()
  }


  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, SnackbarActivity::class.java)
    }
  }

}