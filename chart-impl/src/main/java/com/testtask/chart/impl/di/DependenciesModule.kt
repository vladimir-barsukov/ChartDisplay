package com.testtask.chart.impl.di

import com.testtask.chart.impl.data.repository.ChartRepositoryImpl
import com.testtask.chart.impl.data.service.ChartWebService
import com.testtask.chart.impl.domain.converter.PointsConverter
import com.testtask.chart.impl.domain.interactor.ChartInteractor
import com.testtask.chart.impl.domain.interactor.ChartInteractorImpl
import com.testtask.chart.impl.domain.repository.ChartRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DependenciesModule {

    @Provides
    fun provideInteractor(repository: ChartRepository): ChartInteractor {
        return ChartInteractorImpl(repository)
    }

    @Provides
    fun provideRepository(webService: ChartWebService, converter: PointsConverter): ChartRepository {
        return ChartRepositoryImpl(webService, converter)
    }

    @Provides
    fun provideConverter(): PointsConverter {
        return PointsConverter()
    }
}