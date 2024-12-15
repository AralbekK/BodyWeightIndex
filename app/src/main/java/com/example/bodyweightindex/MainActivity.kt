package com.example.bodyweightindex

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : Activity() {  // Главная активность
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Находим элементы интерфейса
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)
        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)

        // Устанавливаем обработчик клика на кнопку "Рассчитать"
        buttonCalculate.setOnClickListener {
            val height = editTextHeight.text.toString().toDoubleOrNull() ?: 0.0
            val weight = editTextWeight.text.toString().toDoubleOrNull() ?: 0.0

            // Создаем Intent для перехода на второй экран
            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("height", height)
                putExtra("weight", weight)
                startActivity(this)
            }
        }
    }
}


