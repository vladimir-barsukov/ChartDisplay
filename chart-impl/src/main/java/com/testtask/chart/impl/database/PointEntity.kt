package com.testtask.chart.impl.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Модель описывает одну точку на графике с координатами X и Y в БД
 * @property x координата по оси X
 * @property y координата по оси Y
 */
@Entity(tableName = "points_table")
data class PointEntity(
    @ColumnInfo(name = "x") val x: Double,
    @ColumnInfo(name = "y") val y: Double
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}