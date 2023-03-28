package id.gliacademy.sampleproject.clean_arch.net.data.repository.di


import dagger.Binds
import dagger.Module
import id.gliacademy.sampleproject.clean_arch.net.data.repository.ProvinceRepositoryImpl
import id.gliacademy.sampleproject.clean_arch.net.domain.ProvinceRepository

@Module(includes = [NetworkModule::class])
abstract class RepositoryModule {

  @Binds
  abstract fun provideRepository(repositoryImpl: ProvinceRepositoryImpl): ProvinceRepository

}