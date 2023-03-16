package id.gliacademy.sampleproject.api_arch.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import id.gliacademy.sampleproject.api_arch.data.services.Province
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

    viewModel.getProvinceRepositoryModel().observe(this) {
      if (it == null) return@observe
//      when (it.state) {
//        ProvinceRepositoryModel.STATE_LOADING -> showLoading(it.isLoading)
//        ProvinceRepositoryModel.STATE_DATA -> setData(it.provinces)
//      }
      Log.d("ProvinceReposX", Gson().toJson(it.provinces))
        showLoading(it.isLoading)
        setData(it.provinces)
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