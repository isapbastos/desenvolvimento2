package br.com.myapplication0

import MarcianoPremium
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Resposta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resposta)

        val pergunta = intent.getStringExtra("pergunta")

        val marciano = MarcianoPremium {
            "Ação personalizada"
        }


        var resposta: String = marciano.responda(pergunta.toString())


        val txtAnswer = findViewById<TextView>(R.id.textViewAnswer)
        txtAnswer.text = resposta


        val voltar = findViewById<Button>(R.id.btn_voltar)
        voltar.setOnClickListener {
            backToMain()
        }

    }

    fun backToMain() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("clear", true)
        }
        startActivity(intent)
    }

    override fun onBackPressed() {
        backToMain()
    }
}