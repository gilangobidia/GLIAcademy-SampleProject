package id.gliacademy.sampleproject.toast

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.gliacademy.sampleproject.R

class ToastActivity : AppCompatActivity() {

  private lateinit var btnToast1: Button
  private lateinit var btnToast2: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_toast)

    setupView()
    setupListener()
  }

  private fun setupView() {
    btnToast1 = findViewById(R.id.btn_toast_1)
    btnToast2 = findViewById(R.id.btn_toast_2)
  }

  private fun setupListener() {
    btnToast1.setOnClickListener {
      onToast1Clicked()
    }

    btnToast2.setOnClickListener {
      onToast2Clicked()
    }
  }

  private fun onToast1Clicked() {
    Toast.makeText(this, "Toast 1", Toast.LENGTH_SHORT).show()
  }

  var toast: Toast? = null

  private fun onToast2Clicked() {
    if (toast != null) toast?.cancel()
    toast = Toast.makeText(this@ToastActivity, "Toast 2", Toast.LENGTH_SHORT)
    toast?.let {
      it.view?.findViewById<TextView>(android.R.id.message)?.gravity = Gravity.CENTER
      it.setGravity(Gravity.CENTER, 0, 0)
      it.show()
    }
  }


  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, ToastActivity::class.java)
    }
  }

}