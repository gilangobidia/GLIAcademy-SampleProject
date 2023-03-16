package id.gliacademy.sampleproject.api

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import androidx.recyclerview.widget.LinearLayoutManager
import id.gliacademy.sampleproject.databinding.ActivityApiBinding

class ApiActivity: AppCompatActivity() {

  private lateinit var binding: ActivityApiBinding

  private lateinit var viewModel: ApiViewModel

  private lateinit var provinceAdapter: ProvinceAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityApiBinding.inflate(layoutInflater)
    setContentView(binding.root)

    viewModel = ViewModelProvider(this, NewInstanceFactory())[ApiViewModel::class.java]

    setupRecyclerViewProvince()
    observeData()
  }

  private fun setupRecyclerViewProvince() {
    provinceAdapter = ProvinceAdapter()

    val layoutManager = LinearLayoutManager(this)
    binding.rvData.layoutManager = layoutManager
    binding.rvData.adapter = provinceAdapter
  }

  private fun observeData() {
    viewModel.provinces.observe(this) { provinces ->
      setData(provinces)
    }

    viewModel.isLoading.observe(this) {
      showLoading(it)
    }
  }

  private fun setData(provinces: List<Province>) {
    provinceAdapter.updateData(provinces)
  }

  private fun showLoading(isLoading: Boolean) {
    binding.progressBar.isVisible = isLoading
  }

  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, ApiActivity::class.java)
    }
  }
}