package com.example.zoohelper


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import com.example.zoohelper.adapter.MyAdapter


class MainActivity : AppCompatActivity() {
    private lateinit var db: MainDb
    private lateinit var animalViewModel: AnimalViewModel
    private lateinit var rbVeterinarian: RadioButton
    private lateinit var rbKeeper:RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        rbVeterinarian = findViewById(R.id.rbVeterinarian)
        rbKeeper = findViewById(R.id.rbKeeper)
        animalViewModel = AnimalViewModel(applicationContext, getSelectedProfession())

        // Обработчик нажатия на кнопку
        btnSubmit.setOnClickListener {
            // Получаем выбранный ответ
            val selectedProfession = when {
                rbVeterinarian.isChecked -> true
                rbKeeper.isChecked -> false
                else -> false
            }

            // Переходим на другую активность, передавая выбранный ответ
            val profession = selectedProfession
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("profession", profession)
            startActivity(intent)
            val animalViewModel = AnimalViewModel(applicationContext,profession)
            db = MainDb.getDB(applicationContext)


        }
    }
    private fun getSelectedProfession(): Boolean {
        return when {
            rbVeterinarian.isChecked -> true
            rbKeeper.isChecked -> false
            else -> false
        }
    }
}

