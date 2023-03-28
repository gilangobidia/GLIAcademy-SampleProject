package id.gliacademy.sampleproject.clean_arch.net.data.repository.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceRepository
import javax.inject.Singleton

@Singleton
@Component(
  modules = [RepositoryModule::class]
)
interface CoreComponent {
  @Component.Factory
  interface Factory {
    fun create(@BindsInstance context: Context): CoreComponent
  }

  fun provideRepository(): ProvinceRepository
}