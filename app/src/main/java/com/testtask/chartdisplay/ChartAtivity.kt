package com.testtask.chartdisplay

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.testtask.chartdisplay.databinding.ActivityChartBinding
import com.testtask.chartdisplay.viewmodel.ChartViewModel

class ChartAtivity : AppCompatActivity() {
    private lateinit var binding: ActivityChartBinding
    private val viewModel: ChartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChartBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}