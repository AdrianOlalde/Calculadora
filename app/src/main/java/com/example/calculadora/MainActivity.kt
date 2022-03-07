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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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
}