package id.gliacademy.sampleproject.clean_arch.net.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceEntity
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceItemModel
import id.gliacademy.sampleproject.databinding.ActivityCleanArchNetworkBinding

class NetworkActivity: AppCompatActivity() {

  private lateinit var binding: ActivityCleanArchNetworkBinding

  private lateinit var viewModel: ProvinceViewModel

  private lateinit var provinceAdapter: ProvinceAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityCleanArchNetworkBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setupRecyclerViewProvince()

    setupViewModel()
    setupObserve()


    viewModel.getProvinces()
  }

  private fun setupViewModel() {
    val factory = ProvinceViewModelFactory.getInstance()
    viewModel = ViewModelProvider(this, factory)[ProvinceViewModel::class.java]
  }

  private fun setupObserve() {
    viewModel.provinces.observe(this) {
      if (it == null) return@observe
      when (it.state) {
        ProvinceEntity.STATE_LOADING -> showLoading(true)
        ProvinceEntity.STATE_SUCCESS -> {
          showLoading(false)
          setData(it.data)
        }
        ProvinceEntity.STATE_ERROR -> {
          showLoading(false)
          Toast.makeText(this@NetworkActivity, "Error", Toast.LENGTH_SHORT).show()
        }
      }
    }
  }

  private fun setupRecyclerViewProvince() {
    provinceAdapter = ProvinceAdapter()

    val layoutManager = LinearLayoutManager(this)
    binding.rvData.layoutManager = layoutManager
    binding.rvData.adapter = provinceAdapter
  }

  private fun setData(provinces: List<ProvinceItemModel>) {
    provinceAdapter.updateData(provinces)
  }

  private fun showLoading(isLoading: Boolean) {
    binding.progressBar.isVisible = isLoading
  }

  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, NetworkActivity::class.java)
    }
  }
}