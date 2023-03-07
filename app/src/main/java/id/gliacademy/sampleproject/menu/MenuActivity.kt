package id.gliacademy.sampleproject.menu

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.gliacademy.sampleproject.R
import id.gliacademy.sampleproject.intent.AActivity
import id.gliacademy.sampleproject.intent.BActivity
import id.gliacademy.sampleproject.intent.CActivity
import id.gliacademy.sampleproject.intent.DActivity

class MenuActivity: AppCompatActivity() {


  private lateinit var tvActivity: TextView
  private lateinit var btnA: Button
  private lateinit var btnB: Button
  private lateinit var btnC: Button
  private lateinit var btnD: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_b)

    setupView()
    setupListener()
    val title: String? = intent.getStringExtra("title")
    val title2: String? = intent.extras?.getString("title")

    tvActivity.text = title
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

      startActivity(
        intent
      )
    }
    btnB.setOnClickListener {
      val intent = Intent(this, BActivity::class.java)
      intent.putExtra("title", "B Activity")
      startActivity(
        intent
      )
    }
    btnC.setOnClickListener {
      val intent = Intent(this, CActivity::class.java)
      intent.putExtra("title", "C Activity")
      startActivity(
        intent
      )
    }
    btnD.setOnClickListener {
      val intent = Intent(this, DActivity::class.java)
      intent.putExtra("title", "D Activity")
      startActivity(
        intent
      )
    }
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.main_menu, menu)
    return super.onCreateOptionsMenu(menu)

  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.action_close -> finish()
      R.id.action_close1,
      R.id.action_close2,
      R.id.action_close3 -> Toast.makeText(this, "Show", Toast.LENGTH_LONG).show()
    }
    return super.onOptionsItemSelected(item)
  }
}