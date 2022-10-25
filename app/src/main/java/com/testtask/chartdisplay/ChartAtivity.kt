package com.testtask.chartdisplay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.testtask.chartdisplay.databinding.ActivityChartBinding

class ChartAtivity : AppCompatActivity() {
    private lateinit var binding: ActivityChartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChartBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}