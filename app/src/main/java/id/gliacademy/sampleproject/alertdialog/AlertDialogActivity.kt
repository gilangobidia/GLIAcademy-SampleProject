package id.gliacademy.sampleproject.alertdialog

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AlertDialog.Builder
import androidx.appcompat.app.AppCompatActivity
import id.gliacademy.sampleproject.R


class AlertDialogActivity : AppCompatActivity() {

  private lateinit var btnAlertDialog1: Button
  private lateinit var btnAlertDialog2: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(id.gliacademy.sampleproject.R.layout.activity_alert_dialog)

    setupView()
    setupListener()
  }

  private fun setupView() {
    btnAlertDialog1 = findViewById(id.gliacademy.sampleproject.R.id.btn_alertdialog_1)
    btnAlertDialog2 = findViewById(id.gliacademy.sampleproject.R.id.btn_alertdialog_2)
  }

  private fun setupListener() {
    btnAlertDialog1.setOnClickListener {
      onAlertDialog1Clicked()
    }

    btnAlertDialog2.setOnClickListener {
      onAlertDialog2Clicked()
    }
  }

  private fun onAlertDialog1Clicked() {
    val alertDialogBuilder = Builder(this)

    alertDialogBuilder.setTitle("Konfirmasi Tutup")

    alertDialogBuilder
      .setMessage("Yakin ingin menutup halaman ini?")
      .setIcon(R.mipmap.ic_launcher)
      .setCancelable(false)
      .setPositiveButton("Ya") { dialog, id ->
        finish()
      }
      .setNegativeButton(
        "Tidak"
      ) { dialog, id ->
        dialog.cancel()
      }
      .setNeutralButton("Test") { dialog, id ->
        Toast.makeText(this@AlertDialogActivity, "Test", Toast.LENGTH_SHORT).show()
      }

    val alertDialog: AlertDialog = alertDialogBuilder.create()
    alertDialog.show()
  }

  private fun onAlertDialog2Clicked() {
    val alertDialogBuilder = Builder(this)

    val dialogView = layoutInflater.inflate(R.layout.fragment_a, null)
    alertDialogBuilder.setView(dialogView)
    alertDialogBuilder.setCancelable(true)
    alertDialogBuilder.setIcon(R.mipmap.ic_launcher)
    alertDialogBuilder.setTitle("Custom Alert Dialog")


    val btn = dialogView.findViewById<Button>(R.id.btn_action)
    btn.setOnClickListener {
      Toast.makeText(this@AlertDialogActivity, "Test", Toast.LENGTH_SHORT).show()
      alertDialogBuilder.setOnDismissListener {
        it.dismiss()
      }
    }

    alertDialogBuilder.show()
  }


  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, AlertDialogActivity::class.java)
    }
  }

}