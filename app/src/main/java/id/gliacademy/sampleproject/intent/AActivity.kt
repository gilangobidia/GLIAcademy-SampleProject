package id.gliacademy.sampleproject.intent

import android.content.Intent
import android.os.Build
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import id.gliacademy.sampleproject.BuildConfig
import id.gliacademy.sampleproject.R

class AActivity : AppCompatActivity() {

  private lateinit var tvActivity: TextView
  private lateinit var btnA: Button
  private lateinit var btnB: Button
  private lateinit var btnC: Button
  private lateinit var btnD: Button

  private lateinit var product: Product

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_a)

    product  = Product("Aqua", 10, 1000)

    setupView()
    setupListener()
    val title: String? = intent.getStringExtra("title")
    val title2: String? = intent.extras?.getString("title")

    val products: Product? =
      if (VERSION.SDK_INT > VERSION_CODES.TIRAMISU)
      intent.getParcelableExtra("product", Product::class.java)
    else intent.getParcelableExtra("product")
    tvActivity.text = products.toString()
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

      val intent =  Intent(this, AActivity::class.java)
      intent.putExtra("title", "A Activity")
      intent.putExtra("product", product)
      startActivity(
        intent
      )
    }
    btnB.setOnClickListener {
      val intent =Intent(this, BActivity::class.java)
     intent.putExtra("product", product)
      startActivity(
        intent
      )
    }
    btnC.setOnClickListener {
      val intent =Intent(this, CActivity::class.java)
      intent.putExtra("title", "C Activity")
      intent.putExtra("product", product)
      startActivity(
        intent
      )
    }
    btnD.setOnClickListener {
      val intent =Intent(this, DActivity::class.java)
      intent.putExtra("title", "D Activity")
      intent.putExtra("product", product)
      startActivity(
        intent
      )
    }
  }

  override fun onNewIntent(intent: Intent?) {
    super.onNewIntent(intent)
    Log.d("onNewIntent", "Triggered")
  }
}