package com.testtask.chart.impl.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PointEntity::class], version = 1)
abstract class ChartRoomDatabase : RoomDatabase() {

    abstract fun pointDao(): PointDao

    companion object {

        fun create(context: Context): ChartRoomDatabase =
            Room.databaseBuilder(context, ChartRoomDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
}

private const val DATABASE_NAME = "chart-db"