package com.example.mycolorpallet

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mycolorpallet.databinding.ActivityHomeBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var selectedView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /*
        ColorWheel is an individual module, used from the git repo below
        https://github.com/AntonPopoff/android-color-wheel
        Since I needed to make a few changes in the UI, I didn't use it as dependency but used as a module.
         */
        val colorWheel = binding.colorWheel
        colorWheel.rgb = Color.rgb(13, 37, 42)
        //Thumb properties
        colorWheel.thumbRadius = 75
        colorWheel.colorChangeListener = { rgb: Int ->
            val bgShape = selectedView.getBackground() as GradientDrawable
            bgShape.setColor(rgb)
        }
        selectedView = binding.view1
        setupViewControls()
    }

    private fun setupViewControls() {
        binding.control1.setOnClickListener {
            updateSelectedControl(binding.control1)
        }
        binding.control2.setOnClickListener {
            updateSelectedControl(binding.control2)
        }
        binding.control3.setOnClickListener { updateSelectedControl(binding.control3) }
    }

    private fun updateSelectedControl(view: View) {
        when (view) {
            binding.control1 -> {
                selectedView = binding.view1
                binding.control1.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.selected)
                )
                binding.control2.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.element_background_color)
                )
                binding.control3.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.element_background_color)
                )
            }
            binding.control2 -> {
                selectedView = binding.view2
                binding.control2.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.selected)
                )
                binding.control1.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.element_background_color)
                )
                binding.control3.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.element_background_color)
                )
            }
            binding.control3 -> {
                selectedView = binding.view3
                binding.control3.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.selected)
                )
                binding.control2.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.element_background_color)
                )
                binding.control1.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.element_background_color)
                )
            }
        }

    }
}