package id.gliacademy.sampleproject.clean_arch.net.data.repository.network.services

import com.google.gson.annotations.SerializedName

data class ProvinceResponse(
    @SerializedName("headers") val header:header,
    @SerializedName("original") val province: List<Province>?
)