package id.gliacademy.sampleproject.activity_result

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import id.gliacademy.sampleproject.R

class InputActivity : AppCompatActivity() {

  private lateinit var etName: EditText
  private lateinit var btnResult: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_input)

    etName = findViewById(R.id.et_name)
    btnResult = findViewById(R.id.btn_result)

    btnResult.setOnClickListener {
      val intent = Intent()
      intent.putExtra("name", etName.text.toString())
      setResult(100, intent)
      finish()
    }
  }
}