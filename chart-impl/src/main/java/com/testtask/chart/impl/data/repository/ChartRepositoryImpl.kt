package com.testtask.chart.impl.data.repository

import com.testtask.chart.api.domain.model.Point
import com.testtask.chart.impl.domain.repository.ChartRepository

class ChartRepositoryImpl : ChartRepository {
    override suspend fun getPoints(count: Int): List<Point> {
        TODO("Not yet implemented")
    }
}