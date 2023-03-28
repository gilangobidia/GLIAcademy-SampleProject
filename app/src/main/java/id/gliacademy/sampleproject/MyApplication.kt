package id.gliacademy.sampleproject

import android.app.Application
import id.gliacademy.sampleproject.clean_arch.net.data.repository.di.CoreComponent
import id.gliacademy.sampleproject.clean_arch.net.data.repository.di.DaggerCoreComponent
import id.gliacademy.sampleproject.clean_arch.net.presentation.di.AppComponent
import id.gliacademy.sampleproject.clean_arch.net.presentation.di.DaggerAppComponent

open class MyApplication : Application() {

  private val coreComponent: CoreComponent by lazy {
    DaggerCoreComponent.factory().create(applicationContext)
  }

  val appComponent: AppComponent by lazy {
    DaggerAppComponent.factory().create(coreComponent)
  }
}
