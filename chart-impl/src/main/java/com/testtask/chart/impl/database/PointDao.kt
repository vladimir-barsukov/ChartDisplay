package com.testtask.chart.impl.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Предоставляет интерфейс для доступа к данным
 */
@Dao
interface PointDao {

    @Query("SELECT * FROM points_table")
    suspend fun getAll(): List<PointEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(points: List<PointEntity>)

    @Query("DELETE FROM points_table")
    suspend fun deleteAll()
}