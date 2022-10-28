package com.testtask.chart.impl.di

import com.testtask.chart.impl.domain.interactor.ChartInteractor
import com.testtask.chart.impl.data.repository.ChartRepositoryImpl
import com.testtask.chart.impl.data.service.ChartWebService
import com.testtask.chart.impl.domain.converter.PointsConverter
import com.testtask.chart.impl.domain.interactor.ChartInteractorImpl
import com.testtask.chart.impl.domain.repository.ChartRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DependenciesModule {

    @Singleton
    @Provides
    fun provideInteractor(repository: ChartRepository): ChartInteractor {
        return ChartInteractorImpl(repository)
    }

    @Singleton
    @Provides
    fun provideRepository(webService: ChartWebService, converter: PointsConverter): ChartRepository {
        return ChartRepositoryImpl(webService, converter)
    }

    @Singleton
    @Provides
    fun provideConverter(): PointsConverter {
        return PointsConverter()
    }
}