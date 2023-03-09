package id.gliacademy.sampleproject.companion

import android.view.View

object Utils {

  val name: String = ""
  const val MIN_LENGTH = 6
  const val MAX_LENGTH = 30

  fun View.visible() {
    this.visibility = View.VISIBLE
  }

  fun View.invisible() {
    this.visibility = View.INVISIBLE
  }


  fun View.gone() {
    this.visibility = View.GONE
  }
}