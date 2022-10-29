package com.testtask.chartdisplay

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import com.testtask.chartdisplay.databinding.ActivityMainBinding
import com.testtask.chartdisplay.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        initObservers()
    }

    private fun initObservers() {
        viewModel.pointsData.observe(this) { points ->
            if (points.isEmpty()) {
                showErrorMessage()
            } else {
                // TODO открыть экран с графиком
                //startActivity(Intent(this, ChartAtivity::class.java))
            }
        }
    }

    private fun initViews() {
        with(binding) {
            inputCount.addTextChangedListener { editable ->
                if (editable.isNullOrEmpty()) {
                    showInputError(R.string.error_empty_input_text)
                } else {
                    hideInputError()
                }
            }

            btnGo.setOnClickListener {
                if (inputCount.text.isNullOrEmpty()) {
                    showInputError(R.string.error_empty_input_text)
                } else {
                    inputCount.text?.toString()?.toInt()?.let { viewModel.onGoButtonClicked(it) }
                }
            }
        }
    }

    private fun showErrorMessage() {
        Toast.makeText(this, R.string.error_message, Toast.LENGTH_SHORT).show()
    }

    /** Показывает ошибку в поле ввода количества точек */
    private fun showInputError(error: Int) {
        binding.inputCountContainer.error = getString(error)
        binding.btnGo.isEnabled = false
    }

    private fun hideInputError() {
        binding.inputCountContainer.error = null
        binding.btnGo.isEnabled = true
    }
}