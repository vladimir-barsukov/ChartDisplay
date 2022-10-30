package com.testtask.chartdisplay.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testtask.chart.impl.domain.model.Point
import com.testtask.chartdisplay.databinding.ChartListItemBinding

class PointListAdapter(private val dataSet: List<Point>) : RecyclerView.Adapter<PointListAdapter.ViewHolder>() {

    override fun getItemCount() = dataSet.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ChartListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    class ViewHolder(private val binding: ChartListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(point: Point) {
            binding.x.text = "${point.x}"
            binding.y.text = "${point.y}"
        }
    }
}