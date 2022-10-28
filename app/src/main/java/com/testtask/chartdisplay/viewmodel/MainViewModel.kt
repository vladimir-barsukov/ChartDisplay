package com.testtask.chartdisplay.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testtask.chart.impl.domain.interactor.ChartInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Вью-модель главного экрана
 */
@HiltViewModel
class MainViewModel @Inject constructor(private val interactor: ChartInteractor) : ViewModel() {

    fun onGoButtonClicked(count: Int) {
        viewModelScope.launch { interactor.getPoints(count) }
    }
}