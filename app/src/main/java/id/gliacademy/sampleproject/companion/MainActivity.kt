package id.gliacademy.sampleproject.companion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.gliacademy.sampleproject.R

class MainActivity: AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    MainModel.MAX_LENGTH

    Utils.MIN_LENGTH


  }
}