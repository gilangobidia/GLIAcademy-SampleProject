package id.gliacademy.sampleproject.intent

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
  val name: String,
  val stock: Int,
  val price: Int
): Parcelable