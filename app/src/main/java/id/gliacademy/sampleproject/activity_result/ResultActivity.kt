package id.gliacademy.sampleproject.activity_result

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import id.gliacademy.sampleproject.R

class ResultActivity : AppCompatActivity() {

  private lateinit var tvResult: TextView
  private lateinit var btnInput: Button

  private val resultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
    ActivityResultContracts.StartActivityForResult()
  ) { result ->
    Log.d("result", result.resultCode.toString())
    Log.d("result", result.data.toString())
    if (result.resultCode == 100 && result.data != null) {
      val selectedValue =
        result.data?.getStringExtra("name")
      tvResult.text = "Result : $selectedValue"
    }
  }
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_result)

    tvResult = findViewById(R.id.tv_result)
    btnInput = findViewById(R.id.btn_input)

    btnInput.setOnClickListener {
      resultLauncher.launch(
        Intent(this, InputActivity::class.java)
      )
//      startActivity(
//        Intent(this, InputActivity::class.java)
//      )
    }
  }
}