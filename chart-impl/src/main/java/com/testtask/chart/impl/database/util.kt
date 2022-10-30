package com.testtask.chart.impl.database

import com.testtask.chart.impl.domain.model.Point

fun Point.toPointEntity() = PointEntity(x, y)

fun PointEntity.toPoint() = Point(x, y)