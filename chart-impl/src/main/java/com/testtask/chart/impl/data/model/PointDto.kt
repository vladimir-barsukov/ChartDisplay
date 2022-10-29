package com.testtask.chart.impl.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

/**
 * Модель описывает данные, получаемые от сервера
 * @property x координата по оси X
 * @property y координата по оси Y
 */
@Parcelize
data class PointDto(
    @Json(name = "x") val x: Double,
    @Json(name = "y") val y: Double
) : Parcelable

/**
 * Модель содержит список полученных точек с координатами
 * @property points спсиок точек
 */
@Parcelize
data class PointsDto(
    @Json(name = "points") val points: List<PointDto>?
) : Parcelable
