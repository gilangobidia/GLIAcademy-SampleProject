package id.gliacademy.sampleproject.clean_arch.net.presentation.di

import dagger.Binds
import dagger.Module
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceUseCase
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceUseCaseImpl

@Module
abstract class AppModule {

  @Binds
  abstract fun provideTourismUseCase(useCaseImpl: ProvinceUseCaseImpl): ProvinceUseCase

}