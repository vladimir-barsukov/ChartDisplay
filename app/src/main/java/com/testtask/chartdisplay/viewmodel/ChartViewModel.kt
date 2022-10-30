package com.testtask.chartdisplay.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testtask.chart.impl.database.ChartRoomDatabase
import com.testtask.chart.impl.database.toPoint
import com.testtask.chart.impl.domain.model.Point
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Вью-модель для экрана с графиком и таблицей [ChartActivity]
 */
@HiltViewModel
class ChartViewModel @Inject constructor(private val database: ChartRoomDatabase) : ViewModel() {

    private val _pointsData = MutableLiveData<List<Point>>()
    val pointsData: LiveData<List<Point>> = _pointsData

    fun onScreenOpened() {
        viewModelScope.launch(Dispatchers.IO) {
            val points = database.pointDao().getAll().map { it.toPoint() }
            _pointsData.postValue(points)
        }
    }
}