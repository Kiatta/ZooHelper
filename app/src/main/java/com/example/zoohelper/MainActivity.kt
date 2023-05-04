package com.example.zoohelper


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton



class MainActivity : AppCompatActivity() {
    private lateinit var db: MainDb

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
            val profession = selectedProfession
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("profession", profession)
            startActivity(intent)
            val animalViewModel = AnimalViewModel(applicationContext)
            db = MainDb.getDB(applicationContext)


        }
    }
}