package com.testtask.chart.impl.domain.converter

import com.testtask.chart.impl.domain.model.Point
import com.testtask.chart.impl.data.model.PointDto

/**
 * Конвертер для преобазования [PointDto] в [Point]
 */
class PointsConverter {

    fun convert(from: PointDto) = Point(from.x, from.y)

    fun convertAll(fromList: List<PointDto>): List<Point> {
        return fromList.sortedBy { it.x }.map { convert(it) }
    }
}