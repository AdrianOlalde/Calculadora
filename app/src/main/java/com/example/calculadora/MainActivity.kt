package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var firstValue: Double = 0.0
    var operador: Char = '0'
    var secondValue: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonIgual.setOnClickListener{
            when(operador){
                '+' -> {binding.editTextNumber.setText((firstValue + binding.editTextNumber.text.toString().toDouble()).toString())}
                '-' -> {binding.editTextNumber.setText((firstValue - binding.editTextNumber.text.toString().toDouble()).toString())}
                '÷' -> {binding.editTextNumber.setText((firstValue / binding.editTextNumber.text.toString().toDouble()).toString())}
                'x' -> {binding.editTextNumber.setText((firstValue * binding.editTextNumber.text.toString().toDouble()).toString())}
                else ->{binding.editTextNumber.setText("Error")}
            }
            operador = '0'
            firstValue = 0.0
        }
        binding.buttonPorciento.setOnClickListener{
            binding.editTextNumber.setText(percentage(operador))
        }

    }
    fun NumberInput(view: View){
        val boton = view as Button
        if (binding.editTextNumber.text.contains(".") && boton.id.equals(binding.buttonPunto.id))
            Log.w("Basics", "Ya hay un punto decimal")
        else
            binding.editTextNumber.text.append(boton.text)
    }
    fun clearText(view: View){
        binding.editTextNumber.text.clear()
    }
    fun DeleteText(view: View){
        binding.editTextNumber.setText(binding.editTextNumber.text.dropLast(1))
    }
    fun operatorClicked(view: View){
        val boton = view as Button
        operador = when(boton.id){
            binding.buttonDivision.id -> {'÷'}
            binding.buttonMulti.id -> {'x'}
            binding.buttonSuma.id -> {'+'}
            binding.Resta.id -> {'-'}
            else -> {'0'}
        }
        firstValue = binding.editTextNumber.text.toString().toDouble()
        binding.editTextNumber.text.clear()
    }
    fun percentage(operadorAUsar: Char): String{
        when (operador){
            '0' -> {return "${binding.editTextNumber.text.toString().toDouble()/100}"}
            '+' -> {return "${firstValue + (firstValue*binding.editTextNumber.text.toString().toDouble()/100)}"}
            '-' -> {return "${firstValue - (firstValue*binding.editTextNumber.text.toString().toDouble()/100)}"}
            '÷' -> {return "${firstValue / (firstValue*binding.editTextNumber.text.toString().toDouble()/100)}"}
            'x' -> {return "${firstValue * (firstValue*binding.editTextNumber.text.toString().toDouble()/100)}"}
            else -> {return "ERROR"}
        }
    }
}