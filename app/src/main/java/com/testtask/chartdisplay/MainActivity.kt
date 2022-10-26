package com.testtask.chartdisplay

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.testtask.chartdisplay.databinding.ActivityMainBinding
import com.testtask.chartdisplay.viewmodel.MainViewModel
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        binding.inputCount.addTextChangedListener { editable ->
            if (editable.isNullOrEmpty()) {
                showError(R.string.error_empty_input_text)
            } else {
                hideError()
            }
        }

        binding.btnGo.setOnClickListener {
            if (binding.inputCount.text.isNullOrEmpty()) {
                showError(R.string.error_empty_input_text)
            } else {
                // TODO перейти на экран с графиком
                startActivity(Intent(this, ChartAtivity::class.java))
            }
        }
    }

    private fun showError(error: Int) {
        binding.inputCountContainer.error = getString(error)
        binding.btnGo.isEnabled = false
    }

    private fun hideError() {
        binding.inputCountContainer.error = null
        binding.btnGo.isEnabled = true
    }
}