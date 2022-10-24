package com.testtask.chart.impl.data.model

import com.squareup.moshi.Json

/**
 * Модель описывает данные, получаемые от сервера
 * @property x координата по оси X
 * @property y координата по оси Y
 */
data class PointDto(
    @Json(name = "x") val x: Double,
    @Json(name = "y") val y: Double
)

/**
 * Модель содержит список полученных точек с координатами
 * @property points спсиок точек
 */
data class PointsDto(
    @Json(name = "points") val points: List<PointDto>
)
