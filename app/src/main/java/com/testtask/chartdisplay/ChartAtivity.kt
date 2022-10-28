package com.testtask.chartdisplay

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import com.testtask.chartdisplay.databinding.ActivityChartBinding
import com.testtask.chartdisplay.viewmodel.ChartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChartAtivity : AppCompatActivity() {
    private lateinit var binding: ActivityChartBinding
    private val viewModel: ChartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        // TODO заменить на настоящие данные
        val lines = LineGraphSeries(
            arrayOf(
                DataPoint(-7.2, 5.0),
                DataPoint(-5.1, 2.0),
                DataPoint(-1.2, -5.0),
                DataPoint(1.2, 5.0),
                DataPoint(7.2, 7.0),
                DataPoint(9.2, 2.0),
                DataPoint(12.5, 15.0),
                DataPoint(20.2, 25.0),
                DataPoint(26.2, -5.0),
                DataPoint(28.0, 45.0),
                DataPoint(32.0, 5.0),
                DataPoint(35.0, 18.0),
                DataPoint(40.0, -45.0),
                DataPoint(48.0, 45.0),
                DataPoint(52.0, 21.0),
            )
        )
        binding.graph.addSeries(lines)

        binding.btnSaveImage.setOnClickListener {
            binding.graph.takeSnapshotAndShare(this, getString(R.string.image_name), getString(R.string.share_image_title))
        }
    }
}