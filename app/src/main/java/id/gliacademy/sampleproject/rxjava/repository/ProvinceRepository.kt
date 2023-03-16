package id.gliacademy.sampleproject.rxjava.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.gliacademy.sampleproject.rxjava.data.services.ApiConfig
import id.gliacademy.sampleproject.rxjava.data.services.ProvinceResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class ProvinceRepository {

  val model = MutableLiveData<ProvinceRepositoryModel>()

  fun getProvinces(): LiveData<ProvinceRepositoryModel> {
    model.value = ProvinceRepositoryModel(
      isLoading = true,
      state = ProvinceRepositoryModel.STATE_LOADING
    )

    ApiConfig.getApiService().getProvince()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(object : Observer<ProvinceResponse?> {

        override fun onSubscribe(d: Disposable) {
        }

        override fun onNext(response: ProvinceResponse) {
          model.value = ProvinceRepositoryModel(
            isLoading = false,
            provinces = response.province
          )
        }

        override fun onError(e: Throwable) {
        }

        override fun onComplete() {
        }
      })

    return model
  }
}