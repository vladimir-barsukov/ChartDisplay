package com.testtask.chart.impl.domain.interactor

import com.testtask.chart.impl.domain.model.Point

/**
 * Интерактор предоставляет данные для построения графика
 */
interface ChartInteractor {

    suspend fun getPoints(count: Int): List<Point>
}