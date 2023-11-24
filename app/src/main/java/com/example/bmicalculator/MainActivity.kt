package com.example.bmicalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            calculateBmi()
        }
    }

    private fun calculateBmi() {
        val height = binding.editTextHeight.text.toString().toFloatOrNull()
        val weight = binding.editTextWeight.text.toString().toFloatOrNull()

         if (weight != null && height != null) {
            val imc = weight / (height * height)
            resultMessage(imc)
        } else {
            binding.textViewResult.text = "Por favor insira os valores corretamente"
        }
    }

    private fun resultMessage(imc: Float) {
       val result = when {
           imc < 18.5 -> "Abaixo do peso"
           imc < 24.9 -> "Peso normal"
           imc < 29.9 -> "Sobrepeso"
           imc < 34.9 -> "Obesidade Grau 1"
           imc < 39.9 -> "Obesidade Grau 2"
           else -> "Obesidade Grau 3"
       }
        val message = "Seu índice de massa corporal é ${"%.2f".format(imc).toFloat()}%. Resultado: $result"
        binding.textViewResult.text = message
    }
}