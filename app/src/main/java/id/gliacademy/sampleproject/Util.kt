package id.gliacademy.sampleproject

import android.text.Html
import android.text.Spanned

object Util {

  fun String.fromHtml(): Spanned {
    return Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
  }

}