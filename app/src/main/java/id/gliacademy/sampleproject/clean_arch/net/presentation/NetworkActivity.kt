package id.gliacademy.sampleproject.clean_arch.net.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import id.gliacademy.sampleproject.MyApplication
import id.gliacademy.sampleproject.databinding.ActivityCleanArchNetworkBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class NetworkActivity: AppCompatActivity() {

  private lateinit var binding: ActivityCleanArchNetworkBinding

  private lateinit var provinceAdapter: ProvincePagingAdapter

  @Inject
  lateinit var factory: ProvinceViewModelFactory

  private val viewModel: ProvinceViewModel by viewModels {
    factory
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    (application as MyApplication).appComponent.inject(this)
    super.onCreate(savedInstanceState)
    binding = ActivityCleanArchNetworkBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setupRecyclerViewProvince()

    lifecycleScope.launch {
      viewModel.getProvincess().collectLatest {
        provinceAdapter.submitData(lifecycle, it)
      }
    }
    binding.progressBar.isGone = true
    //viewModel.getProvinces()
  }

/*  private fun setupObserve() {
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
  }*/

  private fun setupRecyclerViewProvince() {
    provinceAdapter = ProvincePagingAdapter()

    val layoutManager = LinearLayoutManager(this)
    binding.rvData.layoutManager = layoutManager
    binding.rvData.adapter = provinceAdapter
  }

/*
  private fun showLoading(isLoading: Boolean) {
    binding.progressBar.isVisible = isLoading
  }
*/

  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, NetworkActivity::class.java)
    }
  }
}