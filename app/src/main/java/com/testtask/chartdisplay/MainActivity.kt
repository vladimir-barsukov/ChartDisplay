package com.testtask.chartdisplay

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
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
            hideLoading()

            if (points.isEmpty()) {
                showErrorMessage()
            } else {
                startActivity(Intent(this, ChartActivity::class.java))
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
                    inputCount.text?.toString()?.toInt()?.let {
                        showLoading()
                        viewModel.onGoButtonClicked(it)
                    }
                }
            }
        }
    }

    private fun showLoading() {
        binding.btnGo.isEnabled = false
        binding.btnGo.setText(R.string.btn_go_loading_title)
    }

    private fun hideLoading() {
        binding.btnGo.isEnabled = true
        binding.btnGo.setText(R.string.btn_go_title)
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