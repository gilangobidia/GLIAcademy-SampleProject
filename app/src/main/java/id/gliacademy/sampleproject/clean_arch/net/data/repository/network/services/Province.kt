package id.gliacademy.sampleproject.clean_arch.net.data.repository.network.services

import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceItemModel

data class Province(
    val No: String?,
    val pH: String?,
    val Temprature: String?,
    val Taste: String?,
    val Odor: String?,
    val Fat: String?,
    val Turbidity: String?,
    val Colour: String?,
    val Grade: String?,
) {

    companion object {
        fun transforms(models: List<Province?>): List<ProvinceItemModel> {
            return models.map {model ->
                transform(Province(
                    model?.No ?: "",
                    model?.pH ?: "",
                    model?.Temprature ?: "",
                    model?.Taste ?: "",
                    model?.Odor ?: "",
                    model?.Fat ?: "",
                    model?.Turbidity ?: "",
                    model?.Colour ?: "",
                    model?.Grade ?: ""
                ))
            }
        }

        private fun transform(model: Province): ProvinceItemModel {
            return ProvinceItemModel(
                model.No ?: "",
                model.pH ?: "",
                model.Temprature ?: "",
                model.Taste ?: "",
                model.Odor ?: "",
                model.Fat ?: "",
                model.Turbidity ?: "",
                model.Colour ?: "",
                model.Grade ?: ""
            )
        }
    }
}