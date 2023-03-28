package id.gliacademy.sampleproject.clean_arch.net.presentation.di

import dagger.Component
import id.gliacademy.sampleproject.clean_arch.net.data.repository.di.CoreComponent
import id.gliacademy.sampleproject.clean_arch.net.presentation.NetworkActivity

@AppScope
@Component(
  dependencies = [CoreComponent::class],
  modules = [AppModule::class]
)
interface AppComponent {
  @Component.Factory
  interface Factory {
    fun create(coreComponent: CoreComponent): AppComponent
  }

  fun inject(activity: NetworkActivity)
}