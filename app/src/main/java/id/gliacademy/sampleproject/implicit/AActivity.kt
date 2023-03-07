package id.gliacademy.sampleproject.implicit

import android.content.Intent
import android.os.Build
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import id.gliacademy.sampleproject.BuildConfig
import id.gliacademy.sampleproject.R
import id.gliacademy.sampleproject.Util
import id.gliacademy.sampleproject.Util.dial
import id.gliacademy.sampleproject.intent.Product

class AActivity : AppCompatActivity() {

  private lateinit var tvActivity: TextView
  private lateinit var btnA: Button
  private lateinit var btnB: Button
  private lateinit var btnC: Button
  private lateinit var btnD: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_a)

    val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
    setSupportActionBar(toolbar)

    val tvToolbar:TextView = findViewById(R.id.tv_toolbar)
    tvToolbar.text = "Activity"

    setupView()
    setupListener()

  }

  private fun setupView() {
    tvActivity = findViewById(R.id.tv_activity)
    btnA = findViewById(R.id.btn_a)
    btnB = findViewById(R.id.btn_b)
    btnC = findViewById(R.id.btn_c)
    btnD = findViewById(R.id.btn_d)
  }

  private fun setupListener() {
    btnA.setOnClickListener {
      this.dial("08234234234")
    }
  }
}