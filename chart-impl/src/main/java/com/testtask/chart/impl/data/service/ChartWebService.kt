package com.testtask.chart.impl.data.service

import com.testtask.chart.impl.data.model.PointsDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Сервис для получения данных от сервера
 */
interface ChartWebService {

    @GET("/api/test/points")
    suspend fun getPoints(@Query("count") count: Int): PointsDto
}