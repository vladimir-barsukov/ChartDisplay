package com.testtask.chart.impl.domain.repository

import com.testtask.chart.api.domain.model.Point

/**
 * Репозиторий для получения точек для построения данных
 */
interface ChartRepository {

    /**
     * Получить заданное количество точек для построения графика
     *
     * @param count количество точек
     */
    suspend fun getPoints(count: Int): List<Point>
}