package id.gliacademy.sampleproject.api

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.gliacademy.sampleproject.databinding.ItemProvinceBinding

class ProvinceAdapter() :
  RecyclerView.Adapter<ProvinceAdapter.ViewHolder>() {

  val provinces: MutableList<Province> = mutableListOf()

  override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
    val binding = ItemProvinceBinding.inflate(
      LayoutInflater.from(viewGroup.context), viewGroup, false
    )
    return ViewHolder(binding)
  }
  override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
    viewHolder.bindData(provinces[position])
  }

  override fun getItemCount() = provinces.size

  fun updateData(newProvinces: List<Province>) {
    provinces.run {
      clear()
      addAll(newProvinces)
    }
    notifyItemRangeChanged(0, provinces.size)
  }

  class ViewHolder(val binding: ItemProvinceBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(province: Province) {
      //binding.tvProvince.text = province.nama
    }
  }
}