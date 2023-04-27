package com.example.zoohelper

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton



class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val rbVeterinarian = findViewById<RadioButton>(R.id.rbVeterinarian)
        val rbKeeper = findViewById<RadioButton>(R.id.rbKeeper)


        // Обработчик нажатия на кнопку
        btnSubmit.setOnClickListener {
            // Получаем выбранный ответ
            val selectedProfession = when {
                rbVeterinarian.isChecked -> "ветеринар"
                rbKeeper.isChecked -> "кипер"
                else -> ""
            }

            // Переходим на другую активность, передавая выбранный ответ
            val intent = Intent(this, com.example.zoohelper.ListActivity::class.java)
            intent.putExtra("profession", selectedProfession)
            startActivity(intent)
            finish()

        }
    }
}