package com.testtask.chartdisplay

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import com.testtask.chartdisplay.databinding.ActivityChartBinding
import com.testtask.chartdisplay.ui.PointListAdapter
import com.testtask.chartdisplay.viewmodel.ChartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChartBinding
    private val viewModel: ChartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        initObservers()
        viewModel.onScreenOpened()
    }

    private fun initViews() {
        binding.btnSaveImage.setOnClickListener {
            binding.graph.takeSnapshotAndShare(
                this,
                getString(R.string.image_name),
                getString(R.string.share_image_title)
            )
        }
    }

    private fun initObservers() {
        viewModel.pointsData.observe(this) { points ->
            val dataPoints = points.map { point -> DataPoint(point.x, point.y) }.toTypedArray()
            val lines = LineGraphSeries(dataPoints)

            with(binding) {
                graph.addSeries(lines)
                title.text = getString(R.string.chart_title, dataPoints.size)
                pointList.layoutManager = LinearLayoutManager(this@ChartActivity)
                pointList.adapter = PointListAdapter(points)
            }
        }
    }
}