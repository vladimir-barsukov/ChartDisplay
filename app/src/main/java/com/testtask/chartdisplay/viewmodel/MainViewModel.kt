package com.testtask.chartdisplay.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testtask.chart.impl.database.ChartRoomDatabase
import com.testtask.chart.impl.database.toPointEntity
import com.testtask.chart.impl.domain.interactor.ChartInteractor
import com.testtask.chart.impl.domain.model.Point
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Вью-модель главного экрана
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val interactor: ChartInteractor,
    private val database: ChartRoomDatabase
) : ViewModel() {

    private val _pointsData = MutableLiveData<List<Point>>()
    val pointsData: LiveData<List<Point>> = _pointsData

    fun onGoButtonClicked(count: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val points = try {
                interactor.getPoints(count)
            } catch (e: Exception) {
                e.printStackTrace()
                emptyList()
            }

            if (points.isNotEmpty()) {
                with(database) {
                    pointDao().deleteAll()
                    pointDao().insertAll(points.map { it.toPointEntity() })
                }
            }

            _pointsData.postValue(points)
        }
    }
}