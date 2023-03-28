package id.gliacademy.sampleproject.clean_arch.net.data.repository.network.services

import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceItemModel

data class Province(
    val id: Int?,
    val nama: String?
) {

    companion object {

        fun transforms(models: List<Province?>): List<ProvinceItemModel> {
            return models.map {
                transform(Province(it?.id, it?.nama))
            }
        }

        private fun transform(model: Province): ProvinceItemModel {
            return ProvinceItemModel(
                model.id ?: 0, model.nama ?: ""
            )
        }
    }
}