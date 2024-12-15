package com.example.bodyweightindex

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ResultActivity : Activity() {  // Активность для отображения результатов
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Находим элементы интерфейса
        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        val imageViewBody: ImageView = findViewById(R.id.imageViewBody)
        val textViewRecommendations: TextView = findViewById(R.id.textViewRecommendations)
        val buttonBack: Button = findViewById(R.id.buttonBack)

        // Получаем данные из Intent
        val height = intent.getDoubleExtra("height", 0.0)
        val weight = intent.getDoubleExtra("weight", 0.0)

        // Рассчитываем индекс массы тела (BMI)
        val bmi = weight / ((height / 100) * (height / 100))
        textViewBMI.text = "Ваш BMI: %.2f".format(bmi)

        // Определяем состояние тела и устанавливаем соответствующие изображения и рекомендации
        when {
            bmi < 18.5 -> {
                imageViewBody.setImageResource(R.drawable.underweight)
                textViewRecommendations.text = "Рекомендации: Больше кушайте"
            }
            bmi in 18.5..24.9 -> {
                imageViewBody.setImageResource(R.drawable.healthy)
                textViewRecommendations.text = "Рекомендации: Ешьте как ели"
            }
            bmi in 25.0..29.9 -> {
                imageViewBody.setImageResource(R.drawable.overweight)
                textViewRecommendations.text = "Рекомендации: Меньше кушайте."
            }
            else -> {
                imageViewBody.setImageResource(R.drawable.obese)
                textViewRecommendations.text = "Рекомендации: Перестаньте так много кушать"
            }
        }

        // Обработчик кнопки "Назад"
        buttonBack.setOnClickListener {
            // Переход на главный экран
            val intent = Intent(this@ResultActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
