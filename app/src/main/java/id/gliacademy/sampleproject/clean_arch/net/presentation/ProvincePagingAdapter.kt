package id.gliacademy.sampleproject.clean_arch.net.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceItemModel
import id.gliacademy.sampleproject.clean_arch.net.presentation.ProvincePagingAdapter.ProvinceViewHolder
import id.gliacademy.sampleproject.databinding.ItemProvinceBinding

class ProvincePagingAdapter :
  PagingDataAdapter<ProvinceItemModel, ProvinceViewHolder>(DiffCallback) {
  companion object {

    object DiffCallback : DiffUtil.ItemCallback<ProvinceItemModel>() {
      override fun areItemsTheSame(
        oldItem: ProvinceItemModel,
        newItem: ProvinceItemModel
      ): Boolean {
        return (oldItem.No == newItem.No)
      }

      override fun areContentsTheSame(
        oldItem: ProvinceItemModel,
        newItem: ProvinceItemModel
      ) = oldItem == newItem
    }
  }

  class ProvinceViewHolder(val binding: ItemProvinceBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindData(province: ProvinceItemModel) {
      //binding.tvProvince.text = province.nama
    }
  }

  override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
    holder.bindData(getItem(position) ?: return)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
    val binding = ItemProvinceBinding.inflate(
      LayoutInflater.from(parent.context), parent, false
    )
    return ProvinceViewHolder(binding)
  }

}