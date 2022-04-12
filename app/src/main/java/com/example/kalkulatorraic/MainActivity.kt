package com.example.kalkulatorraic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.kalkulatorraic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var totalDouble: Double = 0.0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            totalDouble = 0.0
            if (!binding.startingAmount.text.toString().isEmpty()) {
                totalDouble += binding.startingAmount.text.toString().toDouble()
            }

            if (!binding.years.text.toString().isEmpty()) {
                totalDouble *= binding.years.text.toString().toDouble()
            }

            if (!binding.returnRate.text.toString().isEmpty()) {
                totalDouble *= (1.0 + binding.returnRate.text.toString().toDouble()/100.0)
            }

            if (!binding.contributions.text.toString().isEmpty() && !binding.years.text.toString().isEmpty()) {
                totalDouble += binding.contributions.text.toString().toDouble().times(binding.years.text.toString().toDouble())
            }

            if (!totalDouble.equals(0.0)) {
                binding.investText.text = "Invested: " + totalDouble.toString() + "$"
            }
        }

        binding.seekBar.setOnClickListener { this.binding.seekBar
            when(binding.seekBar.progress) {
                1 -> { resources.getDimension(R.dimen.font_small) }
                2 -> { resources.getDimension(R.dimen.font_medium) }
                3 -> { resources.getDimension(R.dimen.font_large) }
            }
        }

        binding.themeSwitch.setOnCheckedChangeListener { _, id ->
            when(id) {
                true -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                false -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}