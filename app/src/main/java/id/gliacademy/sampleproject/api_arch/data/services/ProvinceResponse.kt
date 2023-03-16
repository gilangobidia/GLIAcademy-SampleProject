package id.gliacademy.sampleproject.api_arch.data.services

import com.google.gson.annotations.SerializedName

data class ProvinceResponse(
    @SerializedName("provinsi") val province: List<Province>
)