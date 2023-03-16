package id.gliacademy.sampleproject.api

import com.google.gson.annotations.SerializedName

data class ProvinceResponse(
    @SerializedName("provinsi") val province: List<Province>
)