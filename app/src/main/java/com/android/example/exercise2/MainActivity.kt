package com.android.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            calculateWeight()
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            reset()
        }
    }

    private fun calculateWeight(){
        val weight = findViewById<EditText>(R.id.editTextWeight)
        val height = findViewById<EditText>(R.id.editTextHeight)
        val BMIview = findViewById<TextView>(R.id.textViewBMI)
        val BMIimage = findViewById<ImageView>(R.id.imageViewProfile)


        var BMI = weight.text.toString().toDouble() / ((height.text.toString().toDouble() / 100)*2)

        BMIview.text = (resources.getString(R.string.bmi) + " " + String.format("%.1f", BMI))

        when{
            BMI < 18.5 -> BMIimage.setImageResource(R.drawable.under)
            BMI in 18.5..24.9 -> BMIimage.setImageResource(R.drawable.normal)
            else -> BMIimage.setImageResource(R.drawable.over)
        }


    }

    private fun reset(){
        val weight = findViewById<EditText>(R.id.editTextWeight)
        val height = findViewById<EditText>(R.id.editTextHeight)
        val BMIview = findViewById<TextView>(R.id.textViewBMI)
        val BMIimage = findViewById<ImageView>(R.id.imageViewProfile)

        weight.setText("")
        height.setText("")
        BMIview.text = resources.getString(R.string.bmi)
        BMIimage.setImageResource(R.drawable.empty)

        weight.requestFocus()
    }
}
