package com.testtask.chart.impl.data.repository

import com.testtask.chart.impl.data.service.ChartWebService
import com.testtask.chart.impl.domain.converter.PointsConverter
import com.testtask.chart.impl.domain.model.Point
import com.testtask.chart.impl.domain.repository.ChartRepository
import javax.inject.Inject

class ChartRepositoryImpl @Inject constructor(
    private val webService: ChartWebService,
    private val converter: PointsConverter
) : ChartRepository {

    override suspend fun getPoints(count: Int): List<Point> {
        val points = webService.getPoints(count).points
        return points?.let { converter.convertAll(points) } ?: emptyList()
    }
}