package id.gliacademy.sampleproject.rxjava.data.services

import com.google.gson.annotations.SerializedName

data class ProvinceResponse(
    @SerializedName("provinsi") val province: List<Province>
)