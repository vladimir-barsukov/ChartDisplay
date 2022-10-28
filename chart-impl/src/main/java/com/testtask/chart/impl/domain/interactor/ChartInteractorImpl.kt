package com.testtask.chart.impl.domain.interactor

import com.testtask.chart.impl.domain.model.Point
import com.testtask.chart.impl.domain.repository.ChartRepository
import javax.inject.Inject

class ChartInteractorImpl @Inject constructor(private val repository: ChartRepository) : ChartInteractor {

    override suspend fun getPoints(count: Int): List<Point> {
        return repository.getPoints(count)
    }
}